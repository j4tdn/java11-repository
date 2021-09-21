package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
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
    private static List<Store> getExpectedSaleID(List<Store> data) {
		List<Store> newData = getStores().stream().filter(Store::isSelected).collect(Collectors.toList());
		BigDecimal arg = avarage(newData);
		
		for(Store datas : newData) {
				if(datas.getExpectedSales() == null) {
					if(datas.getReferenceStoreId() != null) {
						if(data.get(datas.getReferenceStoreId().intValue() - 1).getExpectedSales() == null) {
							datas.setExpectedSales(arg);
						}else {
							datas.setExpectedSales(data.get(datas.getReferenceStoreId().intValue() - 1).getExpectedSales());
						}
					}else {
						datas.setExpectedSales(arg);
					}
				}
			}
		return newData;
	}
    private static Map<Long, BigDecimal> getlocationKey(List<Store> data){
		List<Store> newData = getExpectedSaleID(data);
		BigDecimal sum = sum(newData);
		
		Map<Long, BigDecimal> s = new LinkedHashMap<Long, BigDecimal>();
		
		for(Store datas : data) {
				double re = datas.getExpectedSales().doubleValue() / sum.doubleValue();
				BigDecimal result = BigDecimal.valueOf(re);
				s.put(datas.getStoreId(),result.setScale(10, RoundingMode.HALF_UP));
			}
		
		return s;
		
		
	}
    private static  BigDecimal sum(List<Store> data) {
		double sum = 0;
		for (Store datas : data) {
					if(datas.getExpectedSales() == null) {
						continue;
					}
					sum = sum + datas.getExpectedSales().doubleValue();
					
				}
		BigDecimal result = BigDecimal.valueOf(sum);
		return  result.setScale(1, RoundingMode.HALF_UP);
	}
    
    private static  BigDecimal avarage(List<Store> data) {
	    double  sumES = 0;
		int count =  0;
		for (Store datas : data) {
				if(datas.getExpectedSales() == null) {
					continue;
				}
				sumES = sumES + datas.getExpectedSales().doubleValue();
				count ++;
			}
		BigDecimal avarage = BigDecimal.valueOf(sumES / count);
		return avarage.setScale(1, RoundingMode.HALF_UP);
	}
    private static
    
    
    
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
    	// TODO implement your code here and/or other functions
        return null;
    }


}
