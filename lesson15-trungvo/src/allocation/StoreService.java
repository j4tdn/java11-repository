package allocation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreService {
	
	/**
	 * Toan tu ­: + - * /
	 * BigDecimal a = BigDecimal.valueOf(10); 
	 * BigDecimal b = BigDecimal.valueOf(20);
	 * BigDecimal result = a.multiply(b); 
	 * BigDecimal result = a.divide(b); 
	 * BigDecimal result = a.add(b); 
	 * BigDecimal result = a.subtract(b); 
	 * 
	 * Lam tron so 
	 * BigDecimal a = BigDecimal.valueOf(15.23657123648); 
	 * a = a.setScale(4, RoundingMode.HALF_UP);
	 * Result: a = 15.2366
	 */
	
    public static void main(String[] args) {
    	// Input Data
    	final Integer whAllocationAmount = 300;
    	final List<Store> data = getStores();
    	
    	// Thuc hien tinh toan
    	Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, data);
    	
    	// Result
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
    private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
    	     data = getStores();
    	     
    	     if(data.stream().filter(t -> t.getExpectedSales() != null).isParallel()) {
    	    	 List<Store> result= data.stream().filter(t -> t.getExpectedSales() != null ).collect(Collectors.toList());
    	     }
    	     data.stream().map(Store::getReferenceStoreId).equals()
    	    
    	     
    	
    	return null;
    }
    
    private static List<Store> FillMissing(List<Store> stores){
    	 List<Store> result = stores;
    	 
    	 for(Store store: stores ) {
    		 if(store.getExpectedSales() == null ))
    	 }
    }


}