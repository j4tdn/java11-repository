package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class StoreService {

	public static void main(String[] args) {
		// Dữ liệu vào
		final Integer whAllocationAmount = 300;
		final List<Store> selectedStores = getStores().stream()
				.filter(store -> Boolean.TRUE.equals(store.getSelected())).collect(Collectors.toList());

		// Validation
		if (selectedStores.size() != 0) {
			boolean hasNonNullExpectedSales = selectedStores.stream()
					.anyMatch(store -> store.getExpectedSales() != null);
			if (!hasNonNullExpectedSales) {
				System.out.println("Stop calculation");
				System.out.println(
						"Expected sales cannot be calculated. Please add a reference store or include stores with expected sales for interpolation");
				throw new IllegalArgumentException();
			}
		}
		// Thực hiện tính toán
		Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, selectedStores);

		// Kết quả
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
				new Store(7L, 2L, bd(15), null, Boolean.TRUE),
				new Store(8L, null, bd(12), bd(19), Boolean.TRUE),
				new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
				new Store(10L, 7L, bd(18), null, Boolean.TRUE), 
				new Store(11L, null, bd(22), null, Boolean.FALSE));
	}

	private static BigDecimal bd(long value) {
		return BigDecimal.valueOf(value);
	}

	/**
	 * Do Allocation.
	 * 
	 * Key: storeId with Long type Value: storeAllocatedAmount after calculation
	 * with 4 steps
	 * 
	 * @return map of storeId, storeAllocatedAmount
	 */
	private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> stores) {
		// Step 1: Filling in missing expected sales
		Map<Long, BigDecimal> interpolatedExpectedSalesMap = fillMissingExpectedSales(stores);
		
		// Step 2: Calculate Allocation Key
		StoreParamDto<BigDecimal> interpolatedExpectedSales = new StoreParamDto<>(interpolatedExpectedSalesMap, BigDecimal.ZERO, BigDecimal::add);
		Map<Long, BigDecimal> allocationKeyMap = calculateAllocationKey(interpolatedExpectedSales); 
		
		// Step 3: Calculate Allocated Amount
		Map<Long, BigDecimal> stockPreviousDayMap = stores.stream()
				.collect(Collectors.toMap(Store::getStoreId, Store::getStockPreviousDay));
    	StoreParamDto<BigDecimal> stockPreviousDay = new StoreParamDto<>(stockPreviousDayMap, BigDecimal.ZERO, BigDecimal::add);
    	Map<Long, Integer> allocatedAmountMap = calculateAllocatedAmount(allocationKeyMap, whAllocationAmount, stockPreviousDay);
    	
    	// Step 4: fix rounding issues
    	Map<Long, Integer> fixedAllocatedAmountMap = fixRoundingIssue(whAllocationAmount, interpolatedExpectedSalesMap, stockPreviousDayMap, allocatedAmountMap);
    	
    	return fixedAllocatedAmountMap;
	}

	private static Map<Long, BigDecimal> fillMissingExpectedSales(List<Store> stores) {
		Map<Long, BigDecimal> interpolatedExpectedMap = new HashMap<>();

		List<Store> ownStores = stores.stream().filter(store -> store.getExpectedSales() != null)
				.collect(Collectors.toList());

		List<BigDecimal> ownExpectedSales = stores.stream().map(Store::getExpectedSales).filter(Objects::nonNull)
				.collect(Collectors.toList());
		BigDecimal avgExpectedSales = calculateAvgExpectedSales(ownExpectedSales);

		Map<Long, BigDecimal> ownExpectedSalesMap = ownStores.stream()
				.collect(Collectors.toMap(Store::getStoreId, Store::getExpectedSales));
		for (Store store : stores) {
			BigDecimal expectedSales = store.getExpectedSales();
			BigDecimal interpolatedExpectedSales = null;
			if (store.getExpectedSales() != null) {
				interpolatedExpectedSales = expectedSales;
			} else {
				// missing expected sales
				Long referencesStoreId = store.getReferenceStoreId();
				BigDecimal refStorexpectedSales = ownExpectedSalesMap.get(referencesStoreId);
				if (referencesStoreId != null && refStorexpectedSales != null) {
					interpolatedExpectedSales = refStorexpectedSales;
				} else {
					// average
					interpolatedExpectedSales = avgExpectedSales;
				}
			}
			interpolatedExpectedMap.put(store.getStoreId(), interpolatedExpectedSales);
		}

		return interpolatedExpectedMap;
	}
	
	private static Map<Long, Integer> calculateAllocatedAmount(Map<Long, BigDecimal> allocationKeyMap,
			Integer whAllocationAmount, StoreParamDto<BigDecimal> stockPreviousDay) {
		return allocationKeyMap.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> {
			BigDecimal sumStockPreviousDay = stockPreviousDay.getSum();
			BigDecimal stockPreviousPerDay = stockPreviousDay.getStoreParam(e.getKey());
			return Math.max(e.getValue().multiply(bd(whAllocationAmount).add(sumStockPreviousDay))
					.subtract(stockPreviousPerDay).setScale(0, RoundingMode.HALF_UP).intValueExact(), 0);
		}));
	}

	private static Map<Long, BigDecimal> calculateAllocationKey(StoreParamDto<BigDecimal> interpolatedSale) {
		BigDecimal sum = interpolatedSale.getSum();
		return interpolatedSale.getStoreParamMap().stream()
				.collect(Collectors.toMap(Entry::getKey, e -> e.getValue()
				.divide(sum, 10, RoundingMode.HALF_UP)));
	}
	
	private static Map<Long, Integer> fixRoundingIssue(Integer whAllocationAmount,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap, Map<Long, BigDecimal> stockPreviousDayMap,
			Map<Long, Integer> allocatedAmountMap) {
		Map<Long, Integer> fixedAllocatedAmountMap = new HashMap<>(allocatedAmountMap);
		
		StoreParamDto<Integer> allocatedAmount = new StoreParamDto<>(allocatedAmountMap, 0, Integer::sum);
		Integer sumAllocatedAmount = allocatedAmount.getSum();
		if (!sumAllocatedAmount.equals(whAllocationAmount)) {
			Map<Long, Integer> demandMap = calculateDemand(interpolatedExpectedSalesMap, stockPreviousDayMap);
			
			if (sumAllocatedAmount.compareTo(whAllocationAmount) > 0) {
				while (!sumAllocatedAmount.equals(whAllocationAmount)) {
					fixRoundingBiggest(demandMap, fixedAllocatedAmountMap, interpolatedExpectedSalesMap);
					sumAllocatedAmount -= 1;
				}
			} else {
				while (!sumAllocatedAmount.equals(whAllocationAmount)) {
					fixRoundingSmallest(demandMap, fixedAllocatedAmountMap, interpolatedExpectedSalesMap);
					sumAllocatedAmount += 1;
				}
			}
		}
		
		return fixedAllocatedAmountMap;
	}
	
	private static void fixRoundingSmallest(Map<Long, Integer> demandMap, Map<Long, Integer> fixedAllocatedAmountMap,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		
		List<Entry<Long, Integer>> nonZeroAllocateAmount =  fixedAllocatedAmountMap.entrySet().stream()
				.filter(entry -> entry.getValue() != 0)
				.collect(Collectors.toList());
		
		Entry<Long, Integer> selectedStore = nonZeroAllocateAmount.get(0);
		for (Entry<Long, Integer> allocationDto : nonZeroAllocateAmount) {
			Long storeNbr = allocationDto.getKey();
			int smallestDiff = selectedStore.getValue() - demandMap.get(selectedStore.getKey());
			int diff = allocationDto.getValue() - demandMap.get(storeNbr);
			if (diff < smallestDiff) {
				selectedStore = allocationDto;
				continue;
			}
			
			if (diff == smallestDiff) {
				int maxDemand = demandMap.get(selectedStore.getKey());
				int demand = demandMap.get(storeNbr);
				if (demand > maxDemand) {
					selectedStore = allocationDto;
					continue;
				}
				if (demand == maxDemand) {
					BigDecimal maxInterpolatedSales = interpolatedExpectedSalesMap.get(selectedStore.getKey());
					BigDecimal interpolatedSales = interpolatedExpectedSalesMap.get(storeNbr);
					if (interpolatedSales.compareTo(maxInterpolatedSales) > 0) {
						selectedStore = allocationDto;
						continue;
					}
					
					if (interpolatedSales.compareTo(maxInterpolatedSales) == 0) {
						Long minStoreNbr = selectedStore.getKey();
						
						if (storeNbr.compareTo(minStoreNbr) < 0) {
							selectedStore = allocationDto;
						}
					}
				}
			}
		}
		
		int newValue = selectedStore.getValue() + 1;
		selectedStore.setValue(newValue);
		
	}

	private static void fixRoundingBiggest(Map<Long, Integer> demandMap, Map<Long, Integer> fixedAllocatedAmountMap,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		List<Entry<Long, Integer>> nonZeroAllocateAmount =  fixedAllocatedAmountMap.entrySet().stream()
				.filter(entry -> entry.getValue() != 0)
				.collect(Collectors.toList());
		
		Entry<Long, Integer> selectedStore = nonZeroAllocateAmount.get(0);
		for (Entry<Long, Integer> allocationDto : nonZeroAllocateAmount) {
			Long storeNbr = allocationDto.getKey();
			
			int biggestDiff = selectedStore.getValue() - demandMap.get(selectedStore.getKey());
			int diff = allocationDto.getValue() - demandMap.get(storeNbr);
			if (diff > biggestDiff) {
				selectedStore = allocationDto;
				continue;
			}
			
			if (diff == biggestDiff) {
				int minDemand = demandMap.get(selectedStore.getKey());
				int demand = demandMap.get(storeNbr);
				if (demand < minDemand) {
					selectedStore = allocationDto;
					continue;
				}
				if (demand == minDemand) {
					BigDecimal minInterpolatedSales = interpolatedExpectedSalesMap.get(selectedStore.getKey());
					BigDecimal interpolatedSales = interpolatedExpectedSalesMap.get(storeNbr);
					if (interpolatedSales.compareTo(minInterpolatedSales) < 0) {
						selectedStore = allocationDto;
						continue;
					}
					
					if (interpolatedSales.compareTo(minInterpolatedSales) == 0) {
						Long minStoreNbr = selectedStore.getKey();
						
						if (storeNbr.compareTo(minStoreNbr) < 0) {
							selectedStore = allocationDto;
						}
					}
				}
			}
		}
		
		int newValue = selectedStore.getValue() - 1;
		selectedStore.setValue(newValue);
	}

	/////////////////////////////////////////////////
	
	private static Map<Long, Integer> calculateDemand(Map<Long, BigDecimal> interpolatedExpectedSalesMap,
			Map<Long, BigDecimal> stockPreviousDayMap) {
		return interpolatedExpectedSalesMap.entrySet().stream()
				.collect(Collectors.toMap(Entry::getKey, 
						e -> Math.max(e.getValue().subtract(stockPreviousDayMap.get(e.getKey())).intValue(), 0)));
	}

	private static BigDecimal calculateAvgExpectedSales(List<BigDecimal> ownExpectedSales) {
		BigDecimal sumExpectedSales = ownExpectedSales.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		return sumExpectedSales.divide(bd(ownExpectedSales.size()), 1, RoundingMode.HALF_UP);
	}
}