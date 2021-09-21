package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
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
    	Map<Long, Integer> result = getAmountAllocated(data, whAllocationAmount);
    	Map<Long, BigDecimal> difDemands = getDifDemands(data,whAllocationAmount);
    	Map<Long, BigDecimal> demands = getDemandOfStore(data);
   
    	int sum = sumAmountAllcated(result);
    	
  //  	difDemands.entrySet().forEach(System.out::println);
    	
    	
    	if(sum == whAllocationAmount) {
    		return result;
    	}else {
    		if(sum > whAllocationAmount) {
//    			OptionalDouble options = difDemands.entrySet().stream().mapToDouble(d -> d.getValue().doubleValue()).max();
//    	    	Map<Long,Integer> tx = difDemands.entrySet().stream().filter(d -> d.getValue().doubleValue() == options.getAsDouble())
//    	    			.collect(Collectors.toMap(Store::getStoreId, options.getAsDouble()));
//    	    			
//    	    	if(tx.stream().count() == 1) {
//    	    		
//    	    	}
    	    	
    		}
    	}
    	
    	return result;
    }
    
    
    
    
    private static Map<Long, BigDecimal> getDifDemands(List<Store> data, Integer whAllocationAmount){
    	Map<Long, BigDecimal> difDemands = new LinkedHashMap<Long, BigDecimal>();
    	Map<Long, BigDecimal> demands = getDemandOfStore(data);
    	Map<Long, Integer> all = getAmountAllocated(data,whAllocationAmount);
		List<Store> newData = getExpectedSaleID(data);
		for(Store s : newData) {
				double sa = all.get(s.getStoreId()) - demands.get(s.getStoreId()).doubleValue();
				if(sa < 0) {
					sa = 0;
				}
				difDemands.put(s.getStoreId(), BigDecimal.valueOf(sa).setScale(0, RoundingMode.HALF_UP));
			}
    	return difDemands;
    }
    
    private static Map<Long, BigDecimal> getDemandOfStore(List<Store> data){
    	Map<Long, BigDecimal> demands = new LinkedHashMap<Long, BigDecimal>();
    	List<Store> newData = getExpectedSaleID(data);
    	
    	for(Store s : newData) {
				double sa = s.getExpectedSales().doubleValue() - s.getStorePreviousDay().doubleValue();
				if(sa < 0) {
					sa = 0;
				}
				demands.put(s.getStoreId(), BigDecimal.valueOf(sa).setScale(0, RoundingMode.HALF_UP));
			}
    	
    	return demands;
    }
    
    
    private static Map<Long, Integer> getAmountAllocated(List<Store> data, Integer whAllocationAmount){
    	Map<Long, Integer> result = new LinkedHashMap<>();
    	Map<Long, BigDecimal> keys = getAllocationKey(data);
    	List<Store> newData = getExpectedSaleID(data);
		BigDecimal sumStockPreviousDay = sumAllStockPD(newData);
		
		for(Store s : newData) {
				double stock = keys.get(s.getStoreId()).doubleValue() * (whAllocationAmount + sumStockPreviousDay.doubleValue()) - s.getStorePreviousDay().doubleValue();
				BigDecimal st = BigDecimal.valueOf(stock).setScale(0, RoundingMode.HALF_UP);
				if(st.intValue() < 0) {
					st = BigDecimal.valueOf(0);
				}
				result.put(s.getStoreId(),st.intValue());
				
			}
		
    	return result;
    }
    

    private static Map<Long, BigDecimal> getAllocationKey(List<Store> data){
		List<Store> newData = getExpectedSaleID(data);
		BigDecimal sum = sum(newData);
		
		Map<Long, BigDecimal> rs = new LinkedHashMap<Long, BigDecimal>();
		
		for(Store s : newData) {
				double re = s.getExpectedSales().doubleValue() / sum.doubleValue();
				BigDecimal result = BigDecimal.valueOf(re);
				rs.put(s.getStoreId(),result.setScale(10, RoundingMode.HALF_UP));
			}
		
		return rs;
		
		
	}
    
    
    private static List<Store> getExpectedSaleID(List<Store> data) {
		List<Store> newData = getStores().stream().filter(Store::isSelected).collect(Collectors.toList());
		BigDecimal avarage = avarage(newData);
		
		for(Store item : newData) {
				if(item.getExpectedSales() == null) {
					if(item.getReferenceStoreId() != null) {
						if(data.get(item.getReferenceStoreId().intValue() - 1).getExpectedSales() == null) {
								item.setExpectedSales(avarage);
						}else {
							item.setExpectedSales(data.get(item.getReferenceStoreId().intValue() - 1).getExpectedSales());
						}
					}else {
						item.setExpectedSales(avarage);
					}
				}
			}
		return newData;
	}
    
    private static int sumAmountAllcated(Map<Long, Integer> data) {
    	int sum = 0;
    	for (Map.Entry<Long, Integer> entry : data.entrySet()) {
    		sum += entry.getValue();
    	}
    	return sum;
    }
    
    private static BigDecimal sumAllStockPD(List<Store> data) {
		double sum = 0d;
		for (Store s : data) {
				sum = sum + s.getStorePreviousDay().doubleValue();
			}
		BigDecimal result = BigDecimal.valueOf(sum);
		return  result.setScale(1, RoundingMode.HALF_UP);
	}
    
    
    private static  BigDecimal sum(List<Store> data) {
		double sum = 0d;
		for (Store s : data) {
					if(s.getExpectedSales() == null) {
						continue;
					}
					sum = sum + s.getExpectedSales().doubleValue();
					
				}
		BigDecimal result = BigDecimal.valueOf(sum);
		return  result.setScale(1, RoundingMode.HALF_UP);
	}
    
    
    private static  BigDecimal avarage(List<Store> data) {
		double avg = 0l;
		int count =  0;
		for (Store s : data) {
				if(s.getExpectedSales() == null) {
					continue;
				}
				avg = avg + s.getExpectedSales().doubleValue();
				count ++;
			}
		BigDecimal result = BigDecimal.valueOf(avg / count);
		return  result.setScale(1, RoundingMode.HALF_UP);
	}
    
}