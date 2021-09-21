package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		
		System.out.println("========== Step One ==========");
	
		Map<Long, BigDecimal> stepOne = expectedSales(data);
		for (Entry<Long, BigDecimal> entry : stepOne.entrySet()) {
			System.out.println("storeId = " + entry.getKey());
			System.out.println("expectedSales = " + entry.getValue());
		}
		
		System.out.println("========== Step Two ==========");
		allocationKey(stepOne, whAllocationAmount);
		

	
		// Thực hiện tính toán
		// Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount,
		// data);

		// Kết quả
		// storeAllocatedAmouts.entrySet().stream().forEach(System.out::println);
	}

	private static List<Store> getStores() {
		// Store(storeId, referenceStoreId, stockPreviousDay, expectedSales, isSelected)
		return Arrays.asList(new Store(1L, null, bd(18), bd(40), Boolean.TRUE),
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

	private static Map<Long, BigDecimal> expectedSales(List<Store> stores) {
		Map<Long, BigDecimal> result = new HashMap<>();
		Long idRe1;
		BigDecimal referenceStore1;
		Integer id1;
		BigDecimal sum = BigDecimal.valueOf(0);
		BigDecimal avg;
		Double count = 0D;
		
		for (Store store : stores) {
			if (store.getExpectedSales() != null) {
				count++;
				sum = sum.add(store.getExpectedSales());
			}
		}
		BigDecimal sz = BigDecimal.valueOf(count);
		avg = sum.divide(sz);
		avg = avg.setScale(1, RoundingMode.HALF_UP);
		
		System.out.println(avg);

		for (int i = 0; i < stores.size(); i++) {
			if (stores.get(i).getSelected()) {

				if (stores.get(i).getExpectedSales() == null) {

					if (stores.get(i).getReferenceStoreId() != null) {
						idRe1 = stores.get(i).getReferenceStoreId() - 1;
						id1 = Integer.parseInt(idRe1.toString());

						if (stores.get(id1).getExpectedSales() != null) {
							referenceStore1 = stores.get(id1).getExpectedSales();
							stores.get(i).setExpectedSales(referenceStore1);

							result.put(stores.get(i).getStoreId(),
									stores.get(i).getExpectedSales().setScale(1, RoundingMode.HALF_UP));
						}
					}
			
					if (stores.get(i).getReferenceStoreId() == null) {
						stores.get(i).setExpectedSales(avg.setScale(1, RoundingMode.HALF_UP));
						result.put(stores.get(i).getStoreId(),
								stores.get(i).getExpectedSales().setScale(1, RoundingMode.HALF_UP));
					}

				} else {
					result.put(stores.get(i).getStoreId(),
							stores.get(i).getExpectedSales().setScale(1, RoundingMode.HALF_UP));
				}
			}

		}
		return result;
	}
	
	private static void allocationKey(Map<Long, BigDecimal> data, Integer whAllocationAmount) {
		Map<Long, BigDecimal> result = new HashMap<>();
		BigDecimal alKey;
		BigDecimal sum = BigDecimal.valueOf(0);
		
		for (Entry<Long, BigDecimal> entry : data.entrySet()) {
			sum = sum.add(entry.getValue());
		}
		
		System.out.println(sum);
		
		// return result;
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
		return null;
	}
}