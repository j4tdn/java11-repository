package allocation;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

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

		for (Store st : data) {
			st.toString();
		}

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
		// TODO implement your code here and/or other functions
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);

		for (int i = 0; i < data.size(); ++i) {
			if (!data.get(i).getSelected())
				continue;
			if (data.get(i).getExpectedSales() == null) {
				if (data.get(i).getReferenceStoreId() != null) {
					int index = Math.toIntExact(data.get(i).getReferenceStoreId());
					index--;
					if (data.get(index).getReferenceStoreId() == null) {
						data.get(i).setExpectedSales(data.get(index).getExpectedSales());
					} else {
						float sum = 0f;
						int count = 0;
						for (int j = 0; j < data.size(); ++j) {
							if (!data.get(j).getSelected())
								continue;
							if (data.get(j).getReferenceStoreId() == null) {
								count++;
								sum += Double.parseDouble(data.get(j).getExpectedSales().toString());
							}
						}
						Double as = (double) Math.round((sum / (count * 1.0)) * 10) / 10;

						data.get(i).setExpectedSales(new BigDecimal(as.toString()));

					}
				}
			}

		}

		float tmp = 0f;
		for (int i = 0; i < data.size(); ++i) {
			if (!data.get(i).getSelected())
				continue;
			tmp += Double.parseDouble(data.get(i).getExpectedSales().toString());

		}
		float sum = Float.valueOf(df.format(tmp));

		df.setMaximumFractionDigits(10);

		List<Double> list_Alocation_key = new ArrayList<>();
		for (int i = 0; i < data.size(); ++i) {
			if (!data.get(i).getSelected())
				continue;
			list_Alocation_key.add(Double
					.valueOf(df.format(Double.parseDouble(data.get(i).getExpectedSales().toString()) / (int) sum)));
		}

		int sum_stock_day = 0;
		for (int i = 0; i < data.size(); ++i) {
			if (!data.get(i).getSelected())
				continue;
			sum_stock_day += Integer.parseInt(data.get(i).getStorePreviousDay().toString());

		}
		Map<Long, Integer> map = new HashMap<>();
		List<Integer> list_Amount_Allocated = new ArrayList<>();
		for (int i = 0; i < list_Alocation_key.size(); ++i) {

			list_Amount_Allocated.add((int) (list_Alocation_key.get(i) * (whAllocationAmount + sum_stock_day)
					- Integer.parseInt(data.get(i).getStorePreviousDay().toString())));
			map.put((long) i, (int) (list_Alocation_key.get(i) * (whAllocationAmount + sum_stock_day)
					- Integer.parseInt(data.get(i).getStorePreviousDay().toString())));
		}

		return map;
	}

}