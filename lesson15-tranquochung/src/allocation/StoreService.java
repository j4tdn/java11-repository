package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StoreService {

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
				new Store(7L, 2L, bd(15), null, Boolean.TRUE),
				new Store(8L, null, bd(12), bd(19), Boolean.TRUE),
				new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
				new Store(10L, 7L, bd(18), null, Boolean.TRUE), 
				new Store(11L, null, bd(22), null, Boolean.FALSE));
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
		Map<Store, BigDecimal> allocationKey = stepTwo(stepOne);
		Map<Long, Integer> allocationAmount = stepThree(allocationKey, whAllocationAmount);
		while (true) {
			Integer realAllocationAmount = allocationAmount.entrySet().stream().mapToInt(Entry::getValue).sum();
			if (realAllocationAmount.equals(whAllocationAmount)) {
				break;
			}
			stepFour(allocationAmount, stepOne, whAllocationAmount, realAllocationAmount);
		}
		return allocationAmount;
	}

	private static void stepFour(Map<Long, Integer> allocationKey, Map<Store, BigDecimal> stepOne,
			Integer whAllocationAmount, Integer realAllocationAmount) {
		// calculate demand store
		Map<Long, Integer> demandMap = new HashMap<>();
		for (Entry<Store, BigDecimal> entry : stepOne.entrySet()) {
			BigDecimal value = entry.getValue().subtract(entry.getKey().getStorePreviousDay());
			demandMap.put(entry.getKey().getStoreId(), value.intValue());
		}

		// calculate differences Amount Allocated and Demand
		Map<Long, Integer> diff = new HashMap<>();
		for (Entry<Long, Integer> entry : allocationKey.entrySet()) {
			Integer value = entry.getValue() - demandMap.get(entry.getKey());
			diff.put(entry.getKey(), value);
		}

		// fix rounding issues
		OptionalInt option;
		if (whAllocationAmount < realAllocationAmount) {
			option = diff.entrySet().stream().mapToInt(Entry::getValue).max();
		} else {
			option = diff.entrySet().stream().mapToInt(Entry::getValue).min();
		}
		if (option.isPresent()) {
			List<Long> listDiff = diff.entrySet().stream().filter(e -> e.getValue() == option.getAsInt())
					.map(Entry::getKey).collect(Collectors.toList());
			if (listDiff.size() == 1) {
				if(whAllocationAmount < realAllocationAmount) {
					allocationKey.put(listDiff.get(0), allocationKey.get(listDiff.get(0)).intValue() - 1);
				} else {
					allocationKey.put(listDiff.get(0), allocationKey.get(listDiff.get(0)).intValue() + 1);
				}
			} else {
				Map<Long, Integer> mapDemand = new HashMap<>();
				for (Long l : listDiff) {
					for (Entry<Long, Integer> entry : demandMap.entrySet()) {
						if (entry.getKey() == l) {
							mapDemand.put(l, entry.getValue());
						}
					}
				}
				OptionalInt optionDemand;
				if (whAllocationAmount < realAllocationAmount) {
					optionDemand = mapDemand.entrySet().stream().mapToInt(Entry::getValue).max();
				} else {
					optionDemand = mapDemand.entrySet().stream().mapToInt(Entry::getValue).min();
				}
				List<Long> listDemand = mapDemand.entrySet().stream()
						.filter(e -> e.getValue() == optionDemand.getAsInt()).map(Entry::getKey)
						.collect(Collectors.toList());
				if (listDemand.size() == 1) {
					if(whAllocationAmount < realAllocationAmount) {
						allocationKey.put(listDiff.get(0), allocationKey.get(listDiff.get(0)).intValue() - 1);
					} else {
						allocationKey.put(listDiff.get(0), allocationKey.get(listDiff.get(0)).intValue() + 1);
					}
				} else {
					Map<Long, Integer> mapEx = new HashMap<>();
					for (Long l : listDemand) {
						for (Entry<Store, BigDecimal> entry : stepOne.entrySet()) {
							if (entry.getKey().getStoreId() == l) {
								mapEx.put(l, entry.getValue().intValue());
							}
						}
					}
					OptionalInt optionEs;
					if (whAllocationAmount < realAllocationAmount) {
						optionEs = mapDemand.entrySet().stream().mapToInt(Entry::getValue).max();
					} else {
						optionEs = mapDemand.entrySet().stream().mapToInt(Entry::getValue).min();
					}
					List<Long> listEs = stepOne.entrySet().stream()
							.filter(e -> e.getValue().intValue() == optionEs.getAsInt())
							.map(entry -> entry.getKey().getStoreId()).collect(Collectors.toList());
					if (listEs.size() == 1) {
						if(whAllocationAmount < realAllocationAmount) {
							allocationKey.put(listEs.get(0), allocationKey.get(listDiff.get(0)).intValue() - 1);
						} else {
							allocationKey.put(listEs.get(0), allocationKey.get(listDiff.get(0)).intValue() + 1);
						}
					}
				}
			}
		}
	}

	private static Map<Long, Integer> stepThree(Map<Store, BigDecimal> stepTwo, Integer whAllocationAmount) {
		Map<Long, Integer> result = new HashMap<>();
		Optional<BigDecimal> sumSP = stepTwo.entrySet().stream()
				.filter(entry -> entry.getKey().getStorePreviousDay() != null)
				.map(entry -> entry.getKey().getStorePreviousDay()).reduce((a, b) -> a.add(b));
		BigDecimal sumStockPrevious = sumSP.get();
		for (Entry<Store, BigDecimal> entry : stepTwo.entrySet()) {
			BigDecimal amountAllocated = entry.getValue().multiply(bd(whAllocationAmount).add(sumStockPrevious))
					.subtract(entry.getKey().getStorePreviousDay()).setScale(0, RoundingMode.HALF_UP);
			if (amountAllocated.intValue() < 0) {
				amountAllocated = bd(0);
			}
			result.put(entry.getKey().getStoreId(), amountAllocated.intValue());
		}
		return result;
	}

	private static Map<Store, BigDecimal> stepTwo(Map<Store, BigDecimal> stepOne) {
		Map<Store, BigDecimal> result = new HashMap<>();
		BigDecimal sumES = BigDecimal.valueOf(0);
		for (BigDecimal es : stepOne.values()) {
			sumES = es.add(sumES);
		}
		for (Entry<Store, BigDecimal> entry : stepOne.entrySet()) {
			BigDecimal value = entry.getValue().divide(sumES, 10, RoundingMode.HALF_UP);
			result.put(entry.getKey(), value);
		}
		return result;
	}

	private static Map<Store, BigDecimal> stepOne(List<Store> stores) {
		Map<Store, BigDecimal> result = new HashMap<>();

		for (Store store : stores) {
			// use case 1
			if (store.getExpectedSales() != null) {
				result.put(store, store.getExpectedSales().setScale(1, RoundingMode.HALF_UP));
				continue;
			}

			// use case 2
			if (store.getReferenceStoreId() != null) {
				Optional<Store> optStore = stores.stream()
						.filter(s -> s.getStoreId().equals(store.getReferenceStoreId())).findAny();
				if (optStore.isPresent()) {
					if (optStore.get().getExpectedSales() != null) {
						result.put(store, optStore.get().getExpectedSales().setScale(1, RoundingMode.HALF_UP));
						continue;
					}
				}
			}

			// use case other
			Optional<BigDecimal> optES = stores.stream().filter(s -> s.getExpectedSales() != null)
					.map(Store::getExpectedSales).reduce((a, b) -> a.add(b));
			long count = stores.stream().filter(s -> s.getExpectedSales() != null).count();
			BigDecimal avgES = optES.get().divide(bd(count));
			result.put(store, avgES.setScale(1, RoundingMode.HALF_UP));
		}
		return result;
	}

}