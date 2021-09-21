package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StoreService {

	/**
	 * Toán tử: + - * / BigDecimal a = BigDecimal.valueOf(10); BigDecimal b =
	 * BigDecimal.valueOf(20); BigDecimal result = a.multiply(b); BigDecimal result
	 * = a.divide(b); BigDecimal result = a.add(b); BigDecimal result =
	 * a.subtract(b);
	 * 
	 * Làm tròn số BigDecimal a = BigDecimal.valueOf(15.23657123648); a =
	 * a.setScale(4, RoundingMode.HALF_UP); Kết quả: a = 15.2366
	 */

	public static void main(String[] args) {
		// Dữ liệu vào
		final Integer whAllocationAmount = 300;
		final List<Store> data = getStores();

		// Thực hiện tính toán
		// Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount,
		// data);

		Map<Long, BigDecimal> data2 = fillingInMissing(data);
		data2.entrySet().stream().forEach(System.out::println);
		
		// Kết quả
		// storeAllocatedAmouts.entrySet().stream().forEach(System.out::println);
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
		return null;
		// TODO implement your code here and/or other functions

	}

	// step 1
	private static Map<Long, BigDecimal> fillingInMissing(List<Store> data) {
		Map<Long, BigDecimal> expectedSalesProcessed = new HashMap<Long, BigDecimal>();
		Map<Long, Store> tmp = new HashMap<Long, Store>();

		long avgExpectedSales = 0;
		long sumExpectedSales = 0;
		int count = 0;

		for (Store store : data) {
			if (store.getExpectedSales() != null) {
				sumExpectedSales += store.getExpectedSales().doubleValue();
				count++;
			}
		}

		avgExpectedSales = sumExpectedSales / count;

		for (int i = 0; i < data.size(); i++) {
			Store store = data.get(i);
			if (store.getSelected() == true) {
				if (store.getExpectedSales() != null) {
					expectedSalesProcessed.put(store.getStoreId(), store.getExpectedSales());
				} else {
					// data.get(i).getExpectedSales() == null
					if (store.getReferenceStoreId() != null) {
						Store referenceStore = data.stream().filter(el -> el.getStoreId() == store.getReferenceStoreId()).findFirst().get();
						if (referenceStore.getExpectedSales() != null) {
							expectedSalesProcessed.put(store.getStoreId(), referenceStore.getExpectedSales());
						} else {
							expectedSalesProcessed.put(store.getStoreId(), BigDecimal.valueOf(avgExpectedSales));
						}
						
					}

				}

			}
		}

		return expectedSalesProcessed;

	}

	// step 2
	private static Map<Long, BigDecimal> calAllocationKey(List<Store> data,
			Map<Long, BigDecimal> expectedSalesProcessed) {
		Map<Long, BigDecimal> allocationKey = new HashMap<Long, BigDecimal>();
		BigDecimal sumExpectedSales = expectedSalesProcessed.entrySet().stream().map(s -> s.getValue()).reduce(bd(0),
				(a, b) -> a.add(b));
		for (int i = 0; i < data.size(); i++) {
			allocationKey.put(data.get(i).getStoreId(), (data.get(i).getExpectedSales()).divide(sumExpectedSales).setScale(0, RoundingMode.HALF_UP));
		}

		return allocationKey;
	}

	// step 3
	private static Map<Long, BigDecimal> calAmountAllocated(Integer whAllocationAmount, List<Store> data,
			Map<Long, BigDecimal> calAllocationKey) {
		return null;
	}

}