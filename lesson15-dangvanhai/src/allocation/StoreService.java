package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

public class StoreService {
	
	/**
	 * Toán tử: + - * /
	 * BigDecimal a = BigDecimal.valueOf(10); 
	 * BigDecimal b = BigDecimal.valueOf(20);
	 * BigDecimal result = a.multiply(b); 
	 * BigDecimal result = a.divide(b); 
	 * BigDecimal result = a.add(b); 
	 * BigDecimal result = a.subtract(b); 
	 * 
	 * Làm tròn số
	 * BigDecimal a = BigDecimal.valueOf(15.23657123648); 
	 * a = a.setScale(4, RoundingMode.HALF_UP);
	 * Kết quả: a = 15.2366
	 */
	
    public static void main(String[] args) {
    	// Dữ liệu vào
    	final Integer whAllocationAmount = 300;
    	final List<Store> data = getStores();
    	
    	// Thực hiện tính toán
    	Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, data);
    	
    	// Kết quả
//    	storeAllocatedAmouts.entrySet().stream().forEach(System.out::println);
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
    private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
    	// Clear Data
    	data = data.stream().filter(e -> e.getSelected() != Boolean.FALSE)
    		.collect(Collectors.toList());
    	boolean isValid = false;
    	for(Store store : data) {
    		if(store.getExpectedSales() == null) {
    			isValid = true;
    		}
    	}
    	if(!isValid) {
    		System.out.println("Expected sales cannot be calculated. Please add a\r\n" + 
    				"reference store or include stores with expected sales for interpolation");
    		return null;
    	}
    	
    	// Step 1: Filling in missing Expected Sales
    	data = step01(data);
    	System.out.println("======== Step 1 ==========");
    	printf(data);
    	
    	// Step 2: Calculate Allocation Key
    	Map<Store, BigDecimal> allocationKeys = step02(whAllocationAmount, data);
    	System.out.println("======== Step 2 ==========");
    	for(var entry : allocationKeys.entrySet()) {
    		System.out.println(entry);
    	}
    	
    	// Step 3: Calculate Allocation Amout
    	Map<Long, Integer> AllocationAmout = step03(allocationKeys, whAllocationAmount);
    	System.out.println("======== Step 3 ==========");
    	for(var entry : AllocationAmout.entrySet()) {
    		System.out.println(entry);
    	}
    	
    	return null;
    }
    
    private static Map<Long, Integer> step03(Map<Store, BigDecimal> allocationKeys, Integer whAllocationAmount) {
    	Map<Long, Integer> map = new LinkedHashMap<>();
    	BigDecimal AllocationAmount = new BigDecimal(whAllocationAmount);
    	// sum stock previous day
    	BigDecimal sum = bd(0);
    	for(var entry : allocationKeys.entrySet()) {
    		sum.add(entry.getKey().getStorePreviousDay());
    	}
    	
    	// Calculate
    	for(var entry : allocationKeys.entrySet()) {
    		BigDecimal temp =  entry.getValue().multiply((AllocationAmount.add(sum))).subtract(entry.getKey().getStorePreviousDay());
    		int result = temp.intValue();
    		if(result < 0) {
    			result = 0;
    		}
    		map.put(entry.getKey().getStoreId(), result);
    	}
    	return map;
	}

	private static Map<Store, BigDecimal> step02(Integer whAllocationAmount, List<Store> data) {
    	
    	// Calculate Sum
    	BigDecimal sum = data.stream().map(store -> store.getExpectedSales())
    		.reduce(bd(0), (init, current) -> init.add(current));
    	
    	// Calculate Allocation key and put into Map
    	Map<Store, BigDecimal> map = new LinkedHashMap<>();
    	for(Store store : data) {
    		BigDecimal key = store.getExpectedSales().divide(sum, 10, RoundingMode.HALF_UP);
    		key.setScale(10, RoundingMode.HALF_UP);
    		map.put(store, key);
    	}
    	return map;
	}

	private static List<Store> step01(List<Store> data) {
    	// Calculate Average
    	List<Store> newData = data.stream().filter(e -> (e.getExpectedSales() != null))
    			.collect(Collectors.toList());
    	BigDecimal sum = newData.stream().map(e -> e.getExpectedSales())
    		.reduce(bd(0), (init, current) -> init.add(current));
    	BigDecimal average = sum.divide(bd(newData.size()));
    	average = average.setScale(1, RoundingMode.HALF_UP);
    	
    	
    	// Filter store is null Expected
    	final List<Store> tempData = data.stream().filter(e -> e.getExpectedSales() == null
    				&& e.getReferenceStoreId() != null)
    			.collect(Collectors.toList());
    	
    	// Fill by Reference Store
    	for(Store store : data) {
    		if(store.getExpectedSales() == null) {
    			boolean isValid = true;
    			for(Store temp : tempData) {
    				if(temp.getStoreId().equals(store.getReferenceStoreId())) {
    					isValid = false;
    				}
    			}
    			if(isValid) {
    				for(int i = 0; i < data.size(); i++) {
    					if(data.get(i).getStoreId().equals(store.getReferenceStoreId())) {
    						store.setExpectedSales(data.get(i).getExpectedSales());
    					}
    				}
    			}
    		}
    	}
    	
    	// Fill by average
    	for(Store store : data) {
    		if(store.getExpectedSales() == null ) {
    			store.setExpectedSales(average);
    		}
    	}
    	
    	return data;
    }
    
    @SuppressWarnings("unused")
	private static void printf(Collection<?> list) {
    	list.forEach(System.out::println);
    }
    
}