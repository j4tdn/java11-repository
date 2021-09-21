package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Map<Long, BigDecimal> step1 = fillingInMissingExpectedSales(getStores());

		callAllAmountKey(step1);
	}

	/**
	 * Do Allocation.
	 * 
	 * Key: storeId with Long type Value: storeAllocatedAmount after calculation
	 * with 4 steps
	 * 
	 * @return map of storeId, storeAllocatedAmount
	 */
	private static BigDecimal AllAmountLocated = bd(300);

	private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> data) {
		Map<Long, BigDecimal> interpolateExpectedSalesMap = fillingInMissingExpectedSales(data);
		System.out.println(interpolateExpectedSalesMap);

		return null;
	}

	private static Map<Long, BigDecimal> fillingInMissingExpectedSales(List<Store> storeList) {

		Optional<BigDecimal> averageExpectedSalesOptinal = storeList.stream().filter(store -> store.getSelected())
				.filter(store -> store.getExpectedSales() != null).map(store -> store.getExpectedSales())
				.reduce((temp, number) -> (temp.add(number)).divide(BigDecimal.valueOf(2)));

		BigDecimal averageExpectedSales = averageExpectedSalesOptinal.orElse(BigDecimal.valueOf(0));

		Map<Long, Store> longStoreMap = storeList.stream().collect(Collectors.toMap(Store::getStoreId, store -> store));

		longStoreMap.entrySet().stream().forEach(store -> System.out.println(store.getKey() + "" + store.getValue()));

		//
		Map<Long, BigDecimal> step1 = longStoreMap.entrySet().stream()
				.collect(Collectors.toMap(entryStore -> entryStore.getKey(), entryStore -> {

					if (entryStore.getValue().getExpectedSales() != null) {
						return entryStore.getValue().getExpectedSales();
					}
					if (entryStore.getValue().getReferenceStoreId() != null) {
						if (longStoreMap.get(entryStore.getValue().getReferenceStoreId()).getExpectedSales() != null) {
							return longStoreMap.get(entryStore.getValue().getReferenceStoreId()).getExpectedSales();
						}
						return averageExpectedSales;
					}
					return averageExpectedSales;
				}

				));

		return step1;

	}

	private static Map<Long, BigDecimal> callAllAmountKey(Map<Long, BigDecimal> expectedList) {
		Optional<BigDecimal> sumExpectedSalesOptional = expectedList.entrySet().stream().map(entry -> entry.getValue())
				.reduce((temp, element) -> temp.add(element));
		BigDecimal sumExpectedSales = sumExpectedSalesOptional.isPresent() ? sumExpectedSalesOptional.get() : null;

		expectedList.entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey(),
						entry -> entry.getValue().divide(sumExpectedSales, 10, RoundingMode.HALF_UP)))
				.entrySet().stream().forEach(t -> System.out.println(t));

		return expectedList.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(),
				entry -> entry.getValue().divide(sumExpectedSales, 10, RoundingMode.HALF_UP)));

	}

	private static List<Store> getStores() {
		// Store(storeId, referenceStoreId, stockPreviousDay, expectedSales, isSelected)
		return Arrays.asList(new Store(1L, null, bd(18), bd(40), Boolean.TRUE),
				new Store(2L, null, bd(19), bd(20), Boolean.TRUE), new Store(3L, null, bd(21), bd(17), Boolean.TRUE),
				new Store(4L, null, bd(14), bd(31), Boolean.TRUE), new Store(5L, null, bd(14), bd(10), Boolean.TRUE),
				new Store(6L, null, bd(15), bd(30), Boolean.TRUE), new Store(7L, 2L, bd(15), null, Boolean.TRUE),
				new Store(8L, null, bd(12), bd(19), Boolean.TRUE), new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
				new Store(10L, 7L, bd(18), null, Boolean.TRUE));
	}

	private static BigDecimal bd(long value) {
		return BigDecimal.valueOf(value);
	}

}