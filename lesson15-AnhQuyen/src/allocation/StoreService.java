package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

    /**
     * Do Allocation.
     * 
     * Key: storeId with Long type
     * Value: storeAllocatedAmount after calculation with 4 steps
     * @return map of storeId, storeAllocatedAmount
     */
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
			Map<Long, BigDecimal> interpolatedExpectedSalesMap, Map<Long, BigDecimal> stockPreviousDayMap,
			Map<Long, Integer> allocatedAmountMap) {

		Map<Long, Integer> fixedAllocatedAmountMap = new HashMap<>(allocatedAmountMap);
		
		StoreParamDto<Integer> allocatedAmount = new StoreParamDto<>(allocatedAmountMap, 0, Integer::sum);
		Integer sumAllocatedAmount = allocatedAmount.getSum();
		
		if (sumAllocatedAmount != whAllocationAmount) {
			Map<Long, Integer> demandMap = calculateDemand(interpolatedExpectedSalesMap, stockPreviousDayMap);
			
			if (sumAllocatedAmount > whAllocationAmount) {
				while(!sumAllocatedAmount.equals(whAllocationAmount)) {
					fixRoundingBiggest(demandMap, fixedAllocatedAmountMap, interpolatedExpectedSalesMap);
					sumAllocatedAmount -= 1;
				}
			} else {
				while(sumAllocatedAmount.equals(whAllocationAmount)) {
					fixRoundingSmallest(demandMap, fixedAllocatedAmountMap, interpolatedExpectedSalesMap);
					sumAllocatedAmount += 1;
				}
			}
		}
		
		return fixedAllocatedAmountMap;
	}
	
	
	private static void fixRoundingSmallest(Map<Long, Integer> demandMap, Map<Long, Integer> fixedAllocatedAmountMap,
			Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		Map<Long, Integer> Different = calculateDifferent(fixedAllocatedAmountMap,demandMap);
		Integer MinDifferent = Different.entrySet().stream().min((o1,o2)->o1.getValue()-o2.getValue()).get().getValue();
		if(CheckCount(Different.entrySet(), MinDifferent))
		{
			Long finalId = Different.entrySet().stream().filter(t->t.getValue().equals(MinDifferent)).findFirst().get().getKey();
			fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);	
		}
		else
		{
			List<Long> listId1 = Different.entrySet().stream().filter(t->t.getValue().equals(MinDifferent)).map(t->t.getKey()).collect(Collectors.toList());
			int maxValue = demandMap.get(listId1.get(0));
			for (var item : listId1) {
				if (demandMap.get(item) > maxValue) {
					maxValue = demandMap.get(item);
				}
			}
			int tmp = maxValue;
			if(CheckCount(demandMap.entrySet(), tmp))
			{
				Long finalId = demandMap.entrySet().stream().filter(t->t.getValue().equals(tmp)).findFirst().get().getKey();
				fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);	
			}
			else
			{
				List<Long> listId2 = demandMap.entrySet().stream().filter(t->t.getValue().equals(tmp)).map(t->t.getKey()).collect(Collectors.toList());
				int maxValue1 = interpolatedExpectedSalesMap.get(listId2.get(0)).intValue();
				for (var item : listId2) {
					if (interpolatedExpectedSalesMap.get(item).intValue() > maxValue1) {
						maxValue1 = interpolatedExpectedSalesMap.get(item).intValue();
					}
				}
				int tmp1 = maxValue1;
				if(CheckCount(interpolatedExpectedSalesMap.entrySet(), tmp1))
				{
					Long finalId = interpolatedExpectedSalesMap.entrySet().stream().filter(t->t.getValue().equals(tmp1)).findFirst().get().getKey();
					fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);	
				}
				else
				{
					List<Long> listId3 = interpolatedExpectedSalesMap.entrySet().stream().filter(t->t.getValue().equals(tmp1)).map(t->t.getKey()).collect(Collectors.toList());
					Long finalId = listId3.stream().max((o1,o2)->o1.compareTo(o2)).get();
					fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);
				}
			}
		}
	}

	private static void fixRoundingBiggest(Map<Long, Integer> demandMap, Map<Long, Integer> fixedAllocatedAmountMap,
		Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		Map<Long, Integer> Different = calculateDifferent(fixedAllocatedAmountMap,demandMap);
		Integer MaxDifferent = Different.entrySet().stream().max((o1,o2)->o1.getValue()-o2.getValue()).get().getValue();
		if(CheckCount(Different.entrySet(), MaxDifferent))
		{
			Long finalId = Different.entrySet().stream().filter(t->t.getValue().equals(MaxDifferent)).findFirst().get().getKey();
			fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);	
		}
		else
		{
			List<Long> listId1 = Different.entrySet().stream().filter(t->t.getValue().equals(MaxDifferent)).map(t->t.getKey()).collect(Collectors.toList());
			int minValue = demandMap.get(listId1.get(0));
			for (var item : listId1) {
				if (demandMap.get(item) < minValue) {
					minValue = demandMap.get(item);
				}
			}
			int tmp = minValue;
			if(CheckCount(demandMap.entrySet(), tmp))
			{
				Long finalId = demandMap.entrySet().stream().filter(t->t.getValue().equals(tmp)).findFirst().get().getKey();
				fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);	
			}
			else
			{
				List<Long> listId2 = demandMap.entrySet().stream().filter(t->t.getValue().equals(tmp)).map(t->t.getKey()).collect(Collectors.toList());
				int minValue1 = interpolatedExpectedSalesMap.get(listId2.get(0)).intValue();
				for (var item : listId2) {
					if (interpolatedExpectedSalesMap.get(item).intValue() < minValue1) {
						minValue1 = interpolatedExpectedSalesMap.get(item).intValue();
					}
				}
				int tmp1 = minValue1;
				if(CheckCount(interpolatedExpectedSalesMap.entrySet(), tmp1))
				{
					Long finalId = interpolatedExpectedSalesMap.entrySet().stream().filter(t->t.getValue().equals(tmp1)).findFirst().get().getKey();
					fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);	
				}
				else
				{
					List<Long> listId3 = interpolatedExpectedSalesMap.entrySet().stream().filter(t->t.getValue().equals(tmp1)).map(t->t.getKey()).collect(Collectors.toList());
					Long finalId = listId3.stream().min((o1,o2)->o1.compareTo(o2)).get();
					fixedAllocatedAmountMap.replace(finalId, fixedAllocatedAmountMap.get(finalId)-1);
				}
			}
		}
	}
	private static <E extends Entry> boolean CheckCount(Collection<E> list, Object value)
	{
		int count = 0;
		for(E item : list)
		{
			if(item.getValue().equals(value))
				count++;
		}
		return count>1 ? false : true;
	}
	private static Map<Long, Integer> calculateDifferent(Map<Long, Integer> fixedAllocatedAmountMap,
			Map<Long, Integer> demandMap) {
		Map<Long,Integer> Different = new HashMap<>();
		for(var item : fixedAllocatedAmountMap.entrySet())
		{
			int kq = item.getValue()-demandMap.get(item.getKey());
			Different.put(item.getKey(), kq);
		}
		return Different;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Map<Long, Integer> calculateDemand(Map<Long, BigDecimal> interpolatedExpectedSalesMap,
		Map<Long, BigDecimal> stockPreviousDayMap) {
		Map<Long,Integer> Demand = new HashMap<>();
		for(var item : interpolatedExpectedSalesMap.entrySet())
		{
			int kq = item.getValue().subtract(stockPreviousDayMap.get(item.getKey())).intValue();
			kq = kq<0 ? 0 : kq;
			Demand.put(item.getKey(), kq);
		}
		return Demand;
	}

	private static BigDecimal calculateAvgExpectedSales(List<BigDecimal> ownExpectedSales) {
		BigDecimal sumExpectedSales = ownExpectedSales.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		return sumExpectedSales.divide(bd(ownExpectedSales.size()), 1, RoundingMode.HALF_UP);
	}

}