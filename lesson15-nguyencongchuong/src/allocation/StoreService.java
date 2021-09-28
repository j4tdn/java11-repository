package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreService {

	/**
	 * Toán tử: + - * / BigDecimal a = BigDecimal.valueOf(10); BigDecimal b =
	 * BigDecimal.valueOf(20);
	 * BigDecimal result = a.multiply(b); 
	 * BigDecimal result = a.divide(b); 
	 * BigDecimal result = a.add(b); 
	 * BigDecimal result = a.subtract(b);
	 * 
	 * Làm tròn số BigDecimal a = BigDecimal.valueOf(15.23657123648); a =
	 * a.setScale(4, RoundingMode.HALF_UP); Kết quả: a = 15.2366
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
		return Arrays.asList(new Store(1L, null, bd(18), bd(40), Boolean.TRUE),
				new Store(2L, null, bd(19), bd(20), Boolean.TRUE), new Store(3L, null, bd(21), bd(17), Boolean.TRUE),
				new Store(4L, null, bd(14), bd(31), Boolean.TRUE), new Store(5L, null, bd(14), bd(10), Boolean.TRUE),
				new Store(6L, null, bd(15), bd(30), Boolean.TRUE), new Store(7L, 2L, bd(15), null, Boolean.TRUE),
				new Store(8L, null, bd(12), bd(19), Boolean.TRUE), new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
				new Store(10L, 7L, bd(18), null, Boolean.TRUE), new Store(11L, null, bd(22), null, Boolean.FALSE));
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
	private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
		Map<Long, Integer> result = new HashMap<>();
		for (Store dt : data) {
			if (dt.getSelected() == true) {
				List<Store> st1 = step1(data);
				BigDecimal[] st2 = step2(st1);
				Integer[] st3 = step3(st2, data, whAllocationAmount);
				
			}
		}

		return result;
	}

	private static List<Store> step1(List<Store> data) {
		List<Store> result = new ArrayList<>();
		for (Store dt : data) {
			if (dt.getExpectedSales() == null) {
				if (dt.getReferenceStoreId() != null) {
					for (Store dt1 : data) {
						if (dt.getReferenceStoreId() == dt1.getStoreId() && dt1.getExpectedSales() != null) {
							dt.setExpectedSales(dt1.getExpectedSales());
							result.add(dt);
						}
						if (dt.getReferenceStoreId() == dt1.getStoreId() && dt1.getExpectedSales() == null) {
							long count = 0;
							double avg = 0;
							double sum = 0;
							for (Store dt2 : data) {
								sum += dt2.getExpectedSales().doubleValue();
								count++;
							}
							avg = sum / count;
							BigDecimal tmp = BigDecimal.valueOf(avg);
							tmp.setScale(1, RoundingMode.HALF_UP);
							dt.setExpectedSales(tmp);
							result.add(dt);
						}
					}
				}
				if (dt.getReferenceStoreId() == null) {
					long count = 0;
					double avg = 0;
					double sum = 0;
					for (Store dt2 : data) {
						sum += dt2.getExpectedSales().doubleValue();
						count++;
					}
					avg = sum / count;
					BigDecimal tmp = BigDecimal.valueOf(avg);
					tmp.setScale(1, RoundingMode.HALF_UP);
					dt.setExpectedSales(tmp);
					result.add(dt);
				}
			}

		}

		return result;
	}

	private static BigDecimal[] step2(List<Store> data) {
		BigDecimal[] allocationKeys = null;
		BigDecimal sumExS = null;
		
		for(Store dt: data) {
			sumExS = sumExS.add(dt.getExpectedSales());
			for(BigDecimal allocationKey: allocationKeys) {
				allocationKey = dt.getExpectedSales().divide(sumExS).setScale(10, RoundingMode.HALF_UP);
			}
		}
		
		return allocationKeys;
	}
	
	private static Integer[] step3(BigDecimal[] allocationKeys, List<Store> data, Integer allocationAmount) {
		Integer[] amountAllocatedStore = null;
		
		
		
		return amountAllocatedStore;
	}

}