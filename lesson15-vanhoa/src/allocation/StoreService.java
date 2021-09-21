package allocation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

		BigDecimal wh = bd(whAllocationAmount);
		List<Store> results = data.stream().filter(Store::getSelected).collect(Collectors.toList());
		
		// step 1
		List<Store> step1 = fillExpectedSale(results);
		step1.stream().forEach(System.out::println);

		// step 2
		Map<BigDecimal, Store> allocationKey = allocationKey(step1);

		// step 3
		Map<BigDecimal, Store> allocatedStore = amountAllocatedStore(allocationKey, wh);

		// Thực hiện tính toán
		// Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount,
		// data);

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
		// TODO implement your code here and/or other functions
		return null;
	}

	private static List<Store> fillExpectedSale(List<Store> data) {

		List<Store> result = data;

		for (Store store : data) {

			if (store.getExpectedSales() == null && store.getReferenceStoreId() != null) {
				Store a = null;
				// tim store ref
				for (Store store2 : data) {
					if (store2.getStoreId() == store.getReferenceStoreId()) {
						a = store2;
					}
				}
				if (a.getExpectedSales() != null) {
					store.setExpectedSales(a.getExpectedSales());
				}

			}
		}

		return data;
	}

	private static Map<BigDecimal, Store> allocationKey(List<Store> data) {
		Map<BigDecimal, Store> result = new HashMap<>();
		BigDecimal totalEx = bd(0);
		for (Store store : data) {
			totalEx.add(store.getExpectedSales());
		}
		for (Store store : data) {

			result.put(store.getExpectedSales().divide(totalEx), store);
		}

		return result;
	}

	private static Map<BigDecimal, Store> amountAllocatedStore(Map<BigDecimal, Store> input, BigDecimal allocationAmount) {

		List<Entry<BigDecimal, Store>> list = new LinkedList<>(input.entrySet());
		Map<BigDecimal, Store> results = new HashMap<>();

		// total StockPreviousDay
		BigDecimal totalStockPreviousDay = bd(0);
		for (Entry<BigDecimal, Store> entry : list) {
			totalStockPreviousDay = totalStockPreviousDay.add(entry.getValue().getStorePreviousDay());
		}
		
		for (Entry<BigDecimal, Store> store : list) {
			BigDecimal a = store.getKey().multiply(allocationAmount.add(totalStockPreviousDay))
										 .subtract(store.getValue().getStorePreviousDay());
			store.getValue().setExpectedSales(a);
			results.put(store.getKey(), store.getValue());
		}

		return results;
	}

}