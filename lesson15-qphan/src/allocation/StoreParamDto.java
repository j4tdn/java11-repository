package allocation;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.Set;

/**
 * @param <T>. E.g BigDecimal, Integer
 */
public class StoreParamDto<T> {
	
	private Map<Long, T> storeParamMap;
	private T sum;
	
	public StoreParamDto(Map<Long, T> storeParamMap, T identity, BinaryOperator<T> accumulator) {
		this.storeParamMap = storeParamMap;
		this.sum = storeParamMap.values().stream().reduce(identity, accumulator);
	}
	
	public Set<Entry<Long, T>> getStoreParams() {
		return storeParamMap.entrySet();
	}
	
	public T getStoreParam(Long storeId) {
		return storeParamMap.get(storeId);
	}
	
	public T getSum() {
		return sum;
	}
	
}
