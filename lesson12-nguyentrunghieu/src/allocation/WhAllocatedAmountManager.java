package allocation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WhAllocatedAmountManager {
	
	/**
	 * BigDecimal a = BigDecimal.valueOf(10); 
	 * BigDecimal b = BigDecimal.valueOf(20);
	 * BigDecimal mul = a.multiply(b); 
	 * BigDecimal div = a.divide(b); 
	 * BigDecimal add = a.add(b); 
	 * BigDecimal sub = a.subtract(b); 
	 * 
	 * Rounding
	 * a.setScale(10, RoundingMode.HALF_UP);
	 */
	
    public static void main(String[] args) {
    	final Integer allocationAmount = 300;
    	final List<Store> data = getItems();
    }

    private static List<Store> getItems() {
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
                new Store(11L, null, bd(22), null, Boolean.FALSE)
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
//    private Map<Long, Integer> doAllocation(List<Store> data) {
//        return null;
//    }
    //step 1
    public static List<Store> ExpectedSales(List<Store> data) {
		List<Store> storeSelected = data.stream().filter(store -> store.getSelected()).collect(Collectors.toList());
		System.out.println(storeSelected.hashCode());
		List<Store> storeSelectedClone = new ArrayList<>(storeSelected);
		System.out.println(storeSelectedClone.hashCode());
		Map<Long, Store> map = storeSelectedClone.stream()
				.collect(Collectors.toMap(Store::getStoreId, Function.identity(), (s1, s2) -> s1, LinkedHashMap::new));

		List<Store> temp = storeSelected.stream().filter(s -> s.getExpectedSales() != null)
				.collect(Collectors.toList());
	
		return ExpectedSales(data);
		//-----------to be continue----------------
	}

	
}
