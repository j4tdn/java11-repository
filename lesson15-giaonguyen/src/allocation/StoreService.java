package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    	
    	// Như này là giống như em đang query data từ database 2 lần
    	final List<Store> temp_data = getStores();
    	
    	// Tương tự ở đây
    	// Đặt tên biến khó hiểu :(
    	List<Store> data1 = data.stream().filter(store -> store.getSelected())
    							.collect(Collectors.toList());
    	List<Store> temp = temp_data.stream().filter(store -> store.getSelected())
				.collect(Collectors.toList());
    	
    	BigDecimal interpolatedSalesAvg = sumAvg(temp);
    	
    	//step one
    	for (Store d: data1) {
    		// Em nên kiểm tra store có expected sales bằng null trước khi kiểm tra referenceStore của nó
    		// Mình chỉ quan tâm đến reference store khi own store có expected sales = null
    		if (d.getReferenceStoreId() != null) {
    			String index = Long.toString(d.getReferenceStoreId() - 1);

    			if (!isNullExpectedSales(temp, Integer.parseInt(index))) {
    				d.setExpectedSales(data1.get(Integer.parseInt(index)).getExpectedSales());
    			} else {
    				// Giá trị trung bình của tất cả các các own store chỉ có 1
    				// Em nên đưa tính sum này ra ngoài for
    				d.setExpectedSales(interpolatedSalesAvg);
    			}   				
    		}
    	}
    	
    	data1.stream().forEach(System.out::println);
    	
    	//step two
    	Map<String, BigDecimal> allocationKey = new HashMap<>();
    	BigDecimal sum = sum(data1);
    	System.out.println(sum);
    	int count = 0;
    	for (Store d: data1) {
    		count++;
    		BigDecimal result = BigDecimal.valueOf(0);
    		result = result.add(sum);
    		allocationKey.put("Store " + count , d.getExpectedSales().divide(result,10,RoundingMode.HALF_UP));
    	}
    	
    	for (Map.Entry<String, BigDecimal> entry : allocationKey.entrySet()) {
    		System.out.println(entry.getKey() + ": " + entry.getValue());
    	}
    	
    	// Thực hiện tính toán
//    	Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, data);
    	
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
    
    private static boolean isNullExpectedSales(List<Store> stores, int index) {
    	return stores.get(index).getExpectedSales() == null;
    }
    
    private static BigDecimal sumAvg(List<Store> stores) {
    	BigDecimal sum = BigDecimal.valueOf(0);
    	Long count = 0L;
    	for (Store d: stores) {
    		if (d.getExpectedSales() != null) {
    			count++;
    			sum = sum.add(d.getExpectedSales());
    		}
    	}
    	
    	return (sum.divide(bd(count))).setScale(1, RoundingMode.HALF_UP);
    }
    
    private static BigDecimal sum(List<Store> stores) {
    	BigDecimal sum = BigDecimal.valueOf(0);
    	for (Store d: stores) {
    			sum = sum.add(d.getExpectedSales());
    	}
    	return sum.setScale(1, RoundingMode.HALF_UP);
    }

    /**
     * Do Allocation.
     * 
     * Key: storeId with Long type
     * Value: storeAllocatedAmount after calculation with 4 steps
     * @return map of storeId, storeAllocatedAmount
     */
    private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
    	// TODO implement your code here and/or other functions
        return null;
    }


}
