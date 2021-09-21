package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
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
		List<Store> filData = data.stream().filter(s -> s.getSelected() == true).collect(Collectors.toList());
		Map<Store, BigDecimal> stepOne = stepOne(filData);
		Map<Store, BigDecimal> stepTwo = stepTwo(stepOne);
		Map<Long, Integer> stepThree = stepThree(stepTwo, whAllocationAmount);
		while(true) {
			Integer tmp = 0;
			for (Integer s : stepThree.values()) {
				tmp += s;
			}
			if (tmp < whAllocationAmount || tmp > whAllocationAmount) {
				stepFour(stepThree, stepOne, whAllocationAmount, tmp);
			}
			if (tmp == whAllocationAmount) break;
		}
		return stepThree;
	}
	
	private static void stepFour(Map<Long, Integer> stepThree, Map<Store, BigDecimal> stepOne,Integer whAllocationAmount, Integer realAmount) {
		Map<Long, Integer> demadMap = new HashMap<>();
		for (Entry<Store, BigDecimal> entry : stepOne.entrySet()) {
			BigDecimal demand = entry.getValue().subtract(entry.getKey().getStorePreviousDay());
			demadMap.put(entry.getKey().getStoreId(), demand.intValue());
		}
		
		Map<Long, Integer> diff = new HashMap<>();
		for (Entry<Long, Integer> entry : stepThree.entrySet()) {
			for (Entry<Long, Integer> entry2 : demadMap.entrySet()) {
				if (entry.getKey() == entry.getKey()) {
					diff.put(entry.getKey(), entry.getValue() - entry.getValue());
				}
			}
		}
		if (whAllocationAmount < realAmount) {
			
		}
	}
	
	private static Map<Long, Integer> stepThree(Map<Store, BigDecimal> stepTwo, int whAllocationAmount) {
		Map<Long, Integer> result = new HashMap<>();
		BigDecimal sumStockPrevious = null;
		for (BigDecimal b : stepTwo.values()) {
			sumStockPrevious = b.add(sumStockPrevious);
		}
		for (Entry<Store, BigDecimal> entry : stepTwo.entrySet()) {
			BigDecimal amountAllocated = entry.getValue().multiply(bd(whAllocationAmount).add(sumStockPrevious)).subtract(entry.getKey().getStorePreviousDay());
			if (amountAllocated.intValue() < 0) {
				whAllocationAmount = 0;
			}
			result.put(entry.getKey().getStoreId(), whAllocationAmount);
		}
		return result;
	}
	
	private static Map<Store, BigDecimal> stepTwo(Map<Store, BigDecimal> stepOne) {
		Map<Store, BigDecimal> result = new HashMap<>();
		BigDecimal sum = null;
		for (BigDecimal b : stepOne.values()) {
			sum = b.add(sum);
		}
		sum.setScale(1, RoundingMode.HALF_UP);
		for (Entry<Store, BigDecimal> entry : stepOne.entrySet()) {
			BigDecimal value = entry.getValue().divide(sum);
			result.put(entry.getKey(), value);
		}
		return result;
	}
	
	private static Map<Store, BigDecimal> stepOne(List<Store> stores) {
		Map<Store, BigDecimal> result = new HashMap<>();
		for (Store s : stores) {
			if (s.getExpectedSales() != null) {
				result.put(s, s.getExpectedSales().setScale(1, RoundingMode.HALF_UP));
				continue;
			}
			if (s.getReferenceStoreId() != null) {
				Store refeStore = null;
				for (Store tmp : stores) {
					if (tmp.getStoreId() == s.getReferenceStoreId()) {
						refeStore = tmp;
						break;
					}
				}
				if (refeStore.getExpectedSales() != null) {
					result.put(s, refeStore.getExpectedSales().setScale(1, RoundingMode.HALF_UP));
				}
				continue;
			}
			Optional<BigDecimal> optBd = stores.stream().filter(store -> store.getExpectedSales() != null)
					.map(Store::getExpectedSales).reduce((a, b) -> a.add(b));
			long count = stores.stream().filter(store -> store.getExpectedSales() != null).count();
			BigDecimal avgbd = optBd.get().divide(bd(count));
			result.put(s, avgbd.setScale(1, RoundingMode.HALF_UP));
		}

		return result;

	}

}