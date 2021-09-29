package allocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StoreService {

	public static void main(String[] args) {
		// Dữ liệu vào
		final Integer whAllocationAmount = 300;
		final List<Store> selectedStores = getStores().stream()
				.filter(store -> Boolean.TRUE.equals(store.getSelected())).collect(Collectors.toList());

		// Validation
		if (selectedStores.size() != 0) {
			boolean hasNonNullExpectedSales = selectedStores.stream()
					.anyMatch(store -> store.getExpectedSales() != null);
			if (hasNonNullExpectedSales != true) {
				return;
			}
		}
		// Thực hiện tính toán
		Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, selectedStores);

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
	private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> stores) {
		// Step 1: Filling in missing expected sales
		Map<Long, BigDecimal> interpolatedExpectedSalesMap = fillMissingExpectedSales(stores);
		
		// Step 2: Calculate Allocation Key
		Map<Long, BigDecimal> allocationKeyMap = calculateAllocationKey(interpolatedExpectedSalesMap); 
		
		// Step 3: Calculate Allocated Amount
		
		return null;
	}

	private static Map<Long, BigDecimal> calculateAllocationKey(Map<Long, BigDecimal> interpolatedExpectedSalesMap) {
		Set<Entry<Long, BigDecimal>> entrySet = interpolatedExpectedSalesMap.entrySet();
		BigDecimal sum = interpolatedExpectedSalesMap.entrySet().stream().map(Entry::getValue).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return entrySet.stream()
				.collect(Collectors.toMap(Entry::getKey, e -> e.getValue().divide(sum, 10, RoundingMode.HALF_UP)));
	}

	private static Map<Long, BigDecimal> fillMissingExpectedSales(List<Store> stores) {
		Map<Long, BigDecimal> interpolatedExpectedMap = new HashMap<>();

		List<Store> ownStores = stores.stream().filter(store -> store.getExpectedSales() != null)
				.collect(Collectors.toList());

		List<BigDecimal> ownExpectedSales = stores.stream().map(Store::getExpectedSales).filter(Objects::nonNull)
				.collect(Collectors.toList());
		BigDecimal sumExpectedSales = ownExpectedSales.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal avgExpectedSales = sumExpectedSales.divide(bd(ownExpectedSales.size()), 1, RoundingMode.HALF_UP);

		Map<Long, BigDecimal> ownExpectedSalesMap = ownStores.stream()
				.collect(Collectors.toMap(Store::getStoreId, Store::getExpectedSales));
		for (Store store : stores) {
			BigDecimal expectedSales = store.getExpectedSales();
			BigDecimal interpolatedExpectedSales = null;
			if (store.getExpectedSales() != null) {
				interpolatedExpectedSales = expectedSales;
			} else {
				// missing expected sales
				Long referencesStoreId = store.getReferenceStoreId();
				BigDecimal refStorexpectedSales = ownExpectedSalesMap.get(referencesStoreId);
				if (referencesStoreId != null && refStorexpectedSales != null) {
					interpolatedExpectedSales = refStorexpectedSales;
				} else {
					// average
					interpolatedExpectedSales = avgExpectedSales;
				}
			}
			interpolatedExpectedMap.put(store.getStoreId(), interpolatedExpectedSales);
		}

		return interpolatedExpectedMap;
	}

}