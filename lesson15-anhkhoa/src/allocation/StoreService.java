package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
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
//	private static <E> Map<Long, ?> convert(List<E> list) {
//
//	}

	private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
		if (data.stream().filter(t -> t.getExpectedSales() == null).count() == data.size())
			return null;
		List<Store> newdata = data.stream().filter(t -> t.getSelected() == true).collect(Collectors.toList());
		List<Store> Step1 = StepOne(newdata);
		Map<Long, BigDecimal> Step2 = StepTwo(Step1);
		Map<Long, Integer> Step3 = StepThree(Step2, whAllocationAmount, Step1);
		int test = Step3.entrySet().stream().map(t -> t.getValue()).reduce(0, Integer::sum);
		if (test == whAllocationAmount)
			return Step3;
		Map<Long, Integer> rs = new HashMap<>();
		while (test != whAllocationAmount) {
			if (test > whAllocationAmount) {
				rs = StepFourUp(Step3, Step1);
				test = rs.entrySet().stream().map(t -> t.getValue()).reduce(0, Integer::sum);
			}
			if (test < whAllocationAmount) {
				rs = StepFourLow(Step3, Step1);
				test = rs.entrySet().stream().map(t -> t.getValue()).reduce(0, Integer::sum);
			}
		}
		return rs;
	}

	private static Map<Long, Integer> StepFourLow(Map<Long, Integer> data, List<Store> list) {
		Map<Long, Integer> Demand = new HashMap<>();
		Map<Long, Integer> Different = new HashMap<>();
		Map<Long, BigDecimal> MapTmp = new HashMap<>();
		list.stream().forEach(t -> MapTmp.put(t.getStoreId(), t.getExpectedSales()));
		for (Store item : list) {
			int tmp = item.getExpectedSales().intValue() - item.getStorePreviousDay().intValue();
			tmp = tmp >= 0 ? tmp : 0;
			Demand.put(item.getStoreId(), tmp);
		}
		list.stream()
				.forEach(t -> Different.put(t.getStoreId(), data.get(t.getStoreId()) - Demand.get(t.getStoreId())));
		Integer minValue = Different.entrySet().stream().min((o1, o2) -> o1.getValue() - o2.getValue()).get()
				.getValue();
		List<Entry<Long, Integer>> listId = Different.entrySet().stream().filter(t -> t.getValue().equals(minValue))
				.collect(Collectors.toList());
		if (listId.size() == 1) {
			data.replace(listId.get(0).getKey(), data.get(listId.get(0).getKey()) + 1);
			return data;
		}
		int maxValue = Demand.get(listId.get(0).getKey());
		for (var item : listId) {
			if (Demand.get(item.getKey()) > maxValue) {
				maxValue = Demand.get(item.getKey());
			}
		}
		int tmp = maxValue;
		List<Entry<Long, Integer>> DemanAfter = Demand.entrySet().stream().filter(t -> t.getValue() == tmp)
				.collect(Collectors.toList());
		if (DemanAfter.size() == 1) {
			data.replace(DemanAfter.get(0).getKey(), data.get(DemanAfter.get(0).getKey()) + 1);
			return data;
		}
		BigDecimal maxValue1 = MapTmp.get(DemanAfter.get(0).getKey());
		for (var item : DemanAfter) {
			if (maxValue1.equals(MapTmp.get(item.getKey()))) {
				maxValue1 = MapTmp.get(item.getKey());
			}
		}
		BigDecimal tmp1 = maxValue1;
		List<Entry<Long, BigDecimal>> ExAfter = MapTmp.entrySet().stream().filter(t -> t.getValue().equals(tmp1))
				.collect(Collectors.toList());
		if (ExAfter.size() == 1) {
			data.replace(ExAfter.get(0).getKey(), data.get(ExAfter.get(0).getKey()) + 1);
			return data;
		}
		Long finalId = ExAfter.stream().max((o1, o2) -> o1.getKey().compareTo(o2.getKey())).get().getKey();
		data.replace(finalId, data.get(finalId) + 1);
		return data;
	}

	private static Map<Long, Integer> StepFourUp(Map<Long, Integer> data, List<Store> list) {
		Map<Long, Integer> Demand = new HashMap<>();
		Map<Long, Integer> Different = new HashMap<>();
		Map<Long, BigDecimal> MapTmp = new HashMap<>();
		list.stream().forEach(t -> MapTmp.put(t.getStoreId(), t.getExpectedSales()));
		for (Store item : list) {
			int tmp = item.getExpectedSales().intValue() - item.getStorePreviousDay().intValue();
			tmp = tmp >= 0 ? tmp : 0;
			Demand.put(item.getStoreId(), tmp);
		}
		list.stream()
				.forEach(t -> Different.put(t.getStoreId(), data.get(t.getStoreId()) - Demand.get(t.getStoreId())));
		Integer maxValue = Different.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get()
				.getValue();
		List<Entry<Long, Integer>> listId = Different.entrySet().stream().filter(t -> t.getValue().equals(maxValue))
				.collect(Collectors.toList());
		if (listId.size() == 1) {
			data.replace(listId.get(0).getKey(), data.get(listId.get(0).getKey()) - 1);
			return data;
		}
		int minValue = Demand.get(listId.get(0).getKey());
		for (var item : listId) {
			if (Demand.get(item.getKey()) < minValue) {
				minValue = Demand.get(item.getKey());
			}
		}
		int tmp = minValue;
		List<Entry<Long, Integer>> DemanAfter = Demand.entrySet().stream().filter(t -> t.getValue() == tmp)
				.collect(Collectors.toList());
		if (DemanAfter.size() == 1) {
			data.replace(DemanAfter.get(0).getKey(), data.get(DemanAfter.get(0).getKey()) - 1);
			return data;
		}
		BigDecimal minValue1 = MapTmp.get(DemanAfter.get(0).getKey());
		for (var item : DemanAfter) {
			if (MapTmp.get(item.getKey()).equals(minValue1)) {
				minValue1 = MapTmp.get(item.getKey());
			}
		}
		BigDecimal tmp1 = minValue1;
		List<Entry<Long, BigDecimal>> ExAfter = MapTmp.entrySet().stream().filter(t -> t.getValue().equals(tmp1))
				.collect(Collectors.toList());
		if (ExAfter.size() == 1) {
			data.replace(ExAfter.get(0).getKey(), data.get(ExAfter.get(0).getKey()) - 1);
			return data;
		}
		Long finalId = ExAfter.stream().min((o1, o2) -> o1.getKey().compareTo(o2.getKey())).get().getKey();
		data.replace(finalId, data.get(finalId) - 1);
		return data;
	}

	private static Map<Long, Integer> StepThree(Map<Long, BigDecimal> data, Integer allocationamount,
			List<Store> list) {
		BigDecimal sum = list.stream().map(Store::getStorePreviousDay).reduce(BigDecimal.valueOf(0), BigDecimal::add);
		Map<Long, Integer> rs = new HashMap<>();
		list.stream().forEach(t -> rs.put(t.getStoreId(),
				Tinh(data.get(t.getStoreId()), allocationamount, sum, t.getStorePreviousDay())));
		return rs;
	}

	private static Integer Tinh(BigDecimal allocationKey, Integer ammount, BigDecimal sum, BigDecimal stock) {
		Double tmp = Double.parseDouble(ammount.toString());
		BigDecimal rs = allocationKey.multiply(BigDecimal.valueOf(tmp).add(sum)).subtract(stock);
		return rs.intValue();
	}

	private static Map<Long, BigDecimal> StepTwo(List<Store> data) {
		BigDecimal s = data.stream().map(Store::getExpectedSales).reduce(BigDecimal.valueOf(0), BigDecimal::add);
		Map<Long, BigDecimal> map = new HashMap<>();
		data.stream().forEach(t -> map.put(t.getStoreId(), t.getExpectedSales().divide(s, 10, RoundingMode.HALF_UP)));
		return map;
	}

	private static List<Store> StepOne(List<Store> datat) {
//		Map<Long,Store> map1 = new HashMap<Long, Store>();
//		BigDecimal sum = datat.stream().filter(t -> t.getExpectedSales() != null).map(Store::getExpectedSales)
//				.reduce(BigDecimal.valueOf(0), BigDecimal::add);
//		datat.stream().forEach(t->{map1.put(t.getStoreId(), t);});
//		datat.stream().filter(t->t.getExpectedSales()==null && map1.get(t.getReferenceStoreId()).getExpectedSales()==null).forEach(s->s.setExpectedSales(sum));
//		datat.stream().filter(t->t.getExpectedSales()==null).forEach(t->t.setExpectedSales(map1.get(t.getReferenceStoreId()).getExpectedSales()));
//		return map1;
		List<Store> list1 = datat.stream().filter(t -> t.getExpectedSales() == null).collect(Collectors.toList());
		BigDecimal sum = datat.stream().filter(t -> t.getExpectedSales() != null).map(Store::getExpectedSales)
				.reduce(BigDecimal.valueOf(0), BigDecimal::add);
		sum = sum.divide(BigDecimal.valueOf(datat.size() - list1.size()));
		for (Store item : list1) {
			Store referen = datat.stream().filter(t -> t.getStoreId().equals(item.getReferenceStoreId()))
					.collect(Collectors.toList()).get(0);
			if (referen.getExpectedSales() == null) {
				item.setExpectedSales(sum);
			}
		}
		List<Store> list2 = list1.stream().filter(t -> t.getExpectedSales() == null).collect(Collectors.toList());
		for (Store item : list2) {
			Store referen = datat.stream().filter(t -> t.getStoreId().equals(item.getReferenceStoreId()))
					.collect(Collectors.toList()).get(0);
			item.setExpectedSales(referen.getExpectedSales());
		}
		return datat;
	}
}
