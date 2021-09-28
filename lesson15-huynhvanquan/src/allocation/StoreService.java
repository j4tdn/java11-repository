package allocation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StoreService {

	/**
	 * ToÃ¡n tá»­: + - * / BigDecimal a = BigDecimal.valueOf(10); BigDecimal b =
	 * BigDecimal.valueOf(20); BigDecimal result = a.multiply(b); BigDecimal result
	 * = a.divide(b); BigDecimal result = a.add(b); BigDecimal result =
	 * a.subtract(b);
	 * 
	 * LÃ m trÃ²n sá»‘ BigDecimal a = BigDecimal.valueOf(15.23657123648); a =
	 * a.setScale(4, RoundingMode.HALF_UP); Káº¿t quáº£: a = 15.2366
	 */

	public static void main(String[] args) {
		// Dá»¯ liá»‡u vÃ o
		final Integer whAllocationAmount = 300;
		final List<Store> data = getStores();

		// Thá»±c hiá»‡n tÃ­nh toÃ¡n
		Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, data);

		// Káº¿t quáº£
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
		// TODO implement your code here and/or other functions
		stepOne(whAllocationAmount, data);
		return null;
	}

	private static void stepOne(Integer whAllocationAmount, List<Store> data) {
		Map<Long, Integer> newData = new HashMap<>();
		data = data.stream().filter(store -> store.getSelected() == Boolean.TRUE).collect(Collectors.toList());
		for (int i = 0; i < data.size(); i++)
			if (data.get(i).getExpectedSales() == null) {
				if (data.get(i).getReferenceStoreId() == null) {
					Iterator<Map.Entry<Long, Integer>> iterator = newData.entrySet().iterator();
					newData.put(data.get(i).getReferenceStoreId(), getAverage(iterator));
				} else {
					for (int j = 0; j < data.size(); j++) {
						if (data.get(i).getReferenceStoreId() == data.get(j).getStoreId()
								&& data.get(j).getExpectedSales() == null) {
							Iterator<Map.Entry<Long, Integer>> iterator = newData.entrySet().iterator();
							newData.put(data.get(i).getReferenceStoreId(), getAverage(iterator));
						}
						if (data.get(i).getReferenceStoreId() == data.get(j).getStoreId()
								&& data.get(j).getExpectedSales() != null) {
							newData.put(data.get(i).getReferenceStoreId(),
									// Em đang bị NullPointerException chỗ này
									// Vì expected sales có thể bị null mà em chấm intValueExact >> NPE
									// Đoạn này if else và code hơi rối. Submit code lại a sẽ review sau
									data.get(i).getExpectedSales().intValueExact());
						}
					}

				}
			}
	}

	public static Integer getAverage(Iterator<Map.Entry<Long, Integer>> iterator) {
		int count = 0;
		Integer sum = 0;
		while (iterator.hasNext()) {
			Entry<Long, Integer> entry = iterator.next();
			if (entry.getValue() != null) {
				sum += entry.getValue();
				++count;
			}
		}
		return sum / count;
	}
}