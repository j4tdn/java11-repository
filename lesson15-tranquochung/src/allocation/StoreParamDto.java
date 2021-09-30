package allocation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BinaryOperator;

public class StoreParamDto<T> {
	private Map<Long, T> storeParamMap;
	private T sum;
	
	public StoreParamDto(Map<Long, T> storeParamMap, T identity, BinaryOperator<T> accumulator) {
		this.storeParamMap = storeParamMap;
		this.sum = storeParamMap.values().stream().reduce(identity, accumulator);
	}
	
	public Set<Entry<Long, T>> getStoreParamMap() {
		return storeParamMap.entrySet();
	}
	
	public T getStoreParam(Long storeId) {
		return storeParamMap.get(storeId);
	}
	
	public T getSum() {
		return sum;
	}
}
