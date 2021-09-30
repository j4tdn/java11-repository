package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StoreService {
	
    public static void main(String[] args) {
    	final Integer whAllocationAmount = 300;
    	final List<Store> selectedStores = getStores().stream()
    						.filter(store -> Boolean.TRUE.equals(store.getSelected()))
    						.collect(Collectors.toList());
    	
    	// Validation
    	if (selectedStores.size() != 0) {
    		boolean hasNonNullExpectedSales = selectedStores.stream().anyMatch(store -> store.getExpectedSales() != null);
    		if (!hasNonNullExpectedSales) {
    			System.out.println("Stop calculation");
    			System.out.println("Expected sales cannot be calculated. Please add a reference store or include stores with expected sales for interpolation");
    			throw new IllegalArgumentException();
    		}
    	}
    	
    	Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, selectedStores);
    	storeAllocatedAmouts.entrySet().stream().forEach(System.out::println);
    	
    }

    private static List<Store> getStores() {
    	// Store(storeId, referenceStoreId, stockPreviousDay, expectedSales, isSelected)
        return Arrays.asList(
                new Store(1L, null, bd(18), bd(40), Boolean.TRUE),
                new Store(2L, null, bd(19), bd(20), Boolean.TRUE),
                new Store(3L, null, bd(21), bd(17), Boolean.TRUE),
                new Store(4L, null, bd(14), bd(31), Boolean.TRUE),
                new Store(5L, null, bd(14), bd(10), Boolean.TRUE),
                new Store(6L, null, bd(15), bd(30), Boolean.TRUE),
                new Store(7L, 2L  , bd(15), null  , Boolean.TRUE),
                new Store(8L, null, bd(12), bd(19), Boolean.TRUE),
                new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
                new Store(10L, 7L , bd(18), null  , Boolean.TRUE),
                new Store(11L,null, bd(22), null  , Boolean.FALSE)
        );
    }

    private static BigDecimal bd(long value) {
        return BigDecimal.valueOf(value);
    }

  
    private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> stores) {
    	
    	// Step 1: Filling in missing expected sales
    	Map<Long, BigDecimal> interpolatedExpectedSalesMap = fillMissingExpectedSales(stores);
    	
    	// Step 2: Calculate Allocation Key
    	StoreParamDto<BigDecimal> interpolatedExpectedSales = new StoreParamDto<>(interpolatedExpectedSalesMap, BigDecimal.ZERO, BigDecimal::add);
    	Map<Long, BigDecimal> allocationKeyMap = calculateAllocationKey(interpolatedExpectedSales);
    	
    	// Step 3: Calculate Allocated Amount
    	Map<Long, BigDecimal> stockPreviousDayMap = stores.stream().collect(Collectors.toMap(Store::getStoreId, Store::getStockPreviousDay));
    	StoreParamDto<BigDecimal> stockPreviousDay = new StoreParamDto<>(stockPreviousDayMap, BigDecimal.ZERO, BigDecimal::add);
    	Map<Long, Integer> allocatedAmountMap = calculateAllocatedAmount(allocationKeyMap, whAllocationAmount, stockPreviousDay);
    	
    	// Step 4: Fix rounding issue
    	Map<Long, Integer> fixedAllocatedAmountMap = fixRoundingIssue(whAllocationAmount, interpolatedExpectedSalesMap, stockPreviousDayMap, allocatedAmountMap);
    	
        return fixedAllocatedAmountMap;
    }

	private static Map<Long, BigDecimal> fillMissingExpectedSales(List<Store> stores) {
		Map<Long, BigDecimal> interpolatedExpectedSalesMap = new HashMap<>();
		
		List<Store> ownStores = stores.stream().filter(store -> store.getExpectedSales() != null).collect(Collectors.toList());
		List<BigDecimal> ownExpectedSales = ownStores.stream().map(Store::getExpectedSales).collect(Collectors.toList());
		Map<Long, BigDecimal> ownExpectedSalesMap = ownStores.stream().collect(Collectors.toMap(Store::getStoreId, Store::getExpectedSales));
		BigDecimal avgExpectedSales = calculateAvgExpectedSales(ownExpectedSales);
		
		for (Store store : stores) {
			BigDecimal expectedSales = store.getExpectedSales();
			BigDecimal interpolatedExpectedSales = null;
			if (expectedSales != null) {
				interpolatedExpectedSales = expectedSales;
			} else {
				Long referenceStoreId = store.getReferenceStoreId();
				BigDecimal refStoreExpectedSales = ownExpectedSalesMap.get(referenceStoreId);
				if (referenceStoreId != null && refStoreExpectedSales != null) {
					interpolatedExpectedSales = refStoreExpectedSales;
				} else {
					interpolatedExpectedSales = avgExpectedSales;
				}
			}
			interpolatedExpectedSalesMap.put(store.getStoreId(), interpolatedExpectedSales);
		}
		return interpolatedExpectedSalesMap;
	}
	
	private static Map<Long, BigDecimal> calculateAllocationKey(StoreParamDto<BigDecimal> interpolatedSales) {
		BigDecimal sum = interpolatedSales.getSum();
		return interpolatedSales.getStoreParams().stream()
				.collect(Collectors.toMap(Entry::getKey, e -> e.getValue().divide(sum, 10, RoundingMode.HALF_UP)));
	}
	
	private static Map<Long, Integer> calculateAllocatedAmount(Map<Long, BigDecimal> allocationKeyMap,
			Integer whAllocationAmount, StoreParamDto<BigDecimal> stockPreviousDay) {

		return allocationKeyMap.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> {
			BigDecimal allocationKey = e.getValue();
			BigDecimal sumStockPreviousDay = stockPreviousDay.getSum();
			BigDecimal stockPreviousPerDay = stockPreviousDay.getStoreParam(e.getKey());
			return Math.max(allocationKey.multiply(bd(whAllocationAmount).add(sumStockPreviousDay))
					            .subtract(stockPreviousPerDay)
					            .setScale(0, RoundingMode.HALF_UP).intValueExact(), 0);
		}));
	}
	
	private static Map<Long, Integer> fixRoundingIssue(Integer whAllocationAmount,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap,
			Map<Long, BigDecimal> stockPreviousDayMap,
			Map<Long, Integer> allocatedAmountMap) {

		Map<Long, Integer> fixedAllocatedAmountMap = new HashMap<>(allocatedAmountMap); //clone
		
		StoreParamDto<Integer> allocatedAmount = new StoreParamDto<>(allocatedAmountMap, 0, Integer::sum);
		Integer sumAllocatedAmount = allocatedAmount.getSum();
		
		if (sumAllocatedAmount != whAllocationAmount) {
			StoreParamDto<BigDecimal> stockPreviousDay = new StoreParamDto<>(stockPreviousDayMap, BigDecimal.ZERO, BigDecimal::subtract);
			Map<Long, Integer> demandMap = calculateDemand(interpolatedExpectedSalesMap, stockPreviousDayMap,stockPreviousDay);
			
			if (sumAllocatedAmount > whAllocationAmount) {
				while(sumAllocatedAmount != whAllocationAmount) {
					fixRoundingBiggest(demandMap, fixedAllocatedAmountMap, interpolatedExpectedSalesMap);
					sumAllocatedAmount -= 1;
				}
			} else {
				while(sumAllocatedAmount != whAllocationAmount) {
					fixRoundingSmallest(demandMap, fixedAllocatedAmountMap, interpolatedExpectedSalesMap);
					sumAllocatedAmount += 1;
				}
			}
		}
		
		return fixedAllocatedAmountMap;
	}
	
	
	private static void fixRoundingSmallest(Map<Long, Integer> demandMap, Map<Long, Integer> fixedAllocatedAmountMap,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		// TODO Auto-generated method stub
		
	}

	private static void fixRoundingBiggest(Map<Long, Integer> demandMap, Map<Long, Integer> fixedAllocatedAmountMap,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		
		List<Entry<Long,Integer>> expectAllocatedAmount = fixedAllocatedAmountMap.entrySet().stream().filter(entry -> entry.getValue() != 0)
																			.collect(Collectors.toList());
		System.out.println(expectAllocatedAmount);
		Entry<Long, Integer> selectedStore = expectAllocatedAmount.get(0);
		for(Entry<Long,Integer> allocationDto : expectAllocatedAmount) {
			
			Long storeNum = allocationDto.getKey();
			
			int biggestDiff =  selectedStore.getValue() - demandMap.get(selectedStore.getKey());
			int diff = allocationDto.getValue() - demandMap.get(allocationDto.getKey());
			if(diff > biggestDiff) {
				selectedStore = allocationDto;
				continue;
			}
			if(diff == biggestDiff) {
				int minDemand =  demandMap.get(selectedStore.getKey());
				int demand = demandMap.get(storeNum);
				if(demand < minDemand) {
					selectedStore = allocationDto;
					continue;
				}
				//If two or more stores have the same difference: take the one with smallest Demand
				if(demand == minDemand) {
					BigDecimal minIExpectedSales = interpolatedExpectedSalesMap.get(selectedStore.getKey());
					BigDecimal iExpectedSales = interpolatedExpectedSalesMap.get(storeNum);
					if(iExpectedSales.compareTo(minIExpectedSales) < 0) {
						selectedStore = allocationDto;
						continue;
					}
					if(iExpectedSales.compareTo(minIExpectedSales) == 0 ) {
						Long minStoreNum = selectedStore.getKey();
						
						if(storeNum.compareTo(minStoreNum) < 0 ) {
							selectedStore = allocationDto;
						}
					}
				}
			
			}
		}
		
		int newValue = selectedStore.getValue() - 1;
		selectedStore.setValue(newValue);
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Map<Long, Integer> calculateDemand(Map<Long, BigDecimal> interpolatedExpectedSalesMap,
			Map<Long, BigDecimal> stockPreviousDayMap, StoreParamDto<BigDecimal> stockPreviousDay) {
		
		return interpolatedExpectedSalesMap.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> {
			BigDecimal interpolationExpectedKey = e.getValue();
			BigDecimal stockPreviousPerDay = stockPreviousDay.getStoreParam(e.getKey());
			return Math.max(interpolationExpectedKey.subtract(stockPreviousPerDay)
					            .setScale(0, RoundingMode.HALF_UP).intValueExact(), 0);
		}));
	}

	private static BigDecimal calculateAvgExpectedSales(List<BigDecimal> ownExpectedSales) {
		BigDecimal sumExpectedSales = ownExpectedSales.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		return sumExpectedSales.divide(bd(ownExpectedSales.size()), 1, RoundingMode.HALF_UP);
	}

}