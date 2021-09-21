package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class StoreService {
	
	/**
	 * ToÃ¡n tá»­: + - * /
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
	private static List<Store> list = getStores().stream()
			.filter(e -> (e.getSelected()== true))
	        .collect(Collectors.toList());
    public static void main(String[] args) {
    	// Dá»¯ liá»‡u vÃ o
    	final Integer whAllocationAmount = 300;

    	// Thá»±c hiá»‡n tÃ­nh toÃ¡n
    	//Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, data);
    	
    	
    	// Káº¿t quáº£
    	//storeAllocatedAmouts.entrySet().stream().forEach(System.out::println);
    	
    	Long count = list.stream().filter(e -> e.getExpectedSales() != null).count();
    	for(Store store : list) {
    		if(store.getExpectedSales() == null && store.getReferenceStoreId() == null) {
    			store.setExpectedSales(Lamtron(sumExpectedSale()/count,1));
    		}
    		if(store.getExpectedSales() == null && getExpectedSalebyID(store.getReferenceStoreId()) == null){
    			store.setExpectedSales(Lamtron(sumExpectedSale()/count,1));
    		}
    		if(store.getExpectedSales() == null && store.getReferenceStoreId()!= null) {
    			store.setExpectedSales(getExpectedSalebyID(store.getReferenceStoreId()));
    		}   		
    		else continue;
    	}
    	list.stream().forEach(System.out::println);
    	//step 2
    	Long count2 = list.stream().filter(e -> e.getExpectedSales() != null).count();
    	Map<Long, BigDecimal>  mapAlocate = new HashMap<>();
    	for(Store store : list) {
    		mapAlocate.put(store.getStoreId(), Lamtron(sumExpectedSale() / count2, 10));
    	}
    	
    }	
    
    static private BigDecimal Lamtron(Double x, int index) {
    	BigDecimal a = BigDecimal.valueOf(x); 
   	  	a = a.setScale(index, RoundingMode.HALF_UP);
   	  return a;
    }
    
    private static Double sumExpectedSale() {
    	
    	//BigDecimal total = list.stream().map(e-> e.getExpectedSales()).reduce(0, BigDecimal::longValue);
    	Double sum = 0d;
    	for(Store store : list) {
    		if(store.getExpectedSales() != null) {
    			sum += store.getExpectedSales().doubleValue();
    		}
    		else continue;
    	}
    	return sum;
    }
    private static BigDecimal sumStock() {
    	//BigDecimal total = list.stream().map(e-> e.getExpectedSales()).reduce(0, BigDecimal::longValue);
    	Double sum = 0d;
    	for(Store store : list) {
    		if(store.getStorePreviousDay() != null) {
    			sum += store.getStorePreviousDay().doubleValue();
    		}
    		else continue;
    	}
    	return new BigDecimal(sum);
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
    private static BigDecimal getExpectedSalebyID(Long ID) {
    	BigDecimal expectedSale = bd(0);
    	for(Store store : list) {
    		if(store.getStoreId().equals(ID)) {
    			expectedSale = store.getExpectedSales();
    		}

    	}
    	//Optional ExpectedSale = list.stream().filter(e -> e.getStoreId()== ID).map(Store::getExpectedSales).findFirst(); 
    	//expectedSale = ExpectedSale
    	return  expectedSale;
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
    
    // chua xong  step 3
    private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
    	
    	 Map<Long, Integer> mapAlocation = new HashMap<>();
    	 for(Store store : list) {
    		 mapAlocation.put(store.getStoreId(), amountAlocation(new BigDecimal(whAllocationAmount),null, null).intValue());
    	 }
    	 
    	 return null;
    }	
    private static BigDecimal amountAlocation (BigDecimal whAllocationAmount, BigDecimal key, BigDecimal stock ) {
    	return key.multiply(whAllocationAmount.add(sumStock())).subtract(stock);
    }


}