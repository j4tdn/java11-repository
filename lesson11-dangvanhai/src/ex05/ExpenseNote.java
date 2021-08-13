package ex05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Approach: Clone HashMap + Develop filter and sorting features
 * 
 * @author hai
 *
 */
public class ExpenseNote {
	private final int size8Bit = 256; // Size of UTF-8 table
	private final int sizeOfBuckets = size8Bit * size8Bit + size8Bit; // Size of Buckets
	
	private int size; // Size of My Expense
	private List<Data>[] myBuckets; // My Hashing Table
	private List<Integer> listHashCode; // Archive hashing code

	@SuppressWarnings("unchecked")
	public ExpenseNote() {
		size = 0;
		myBuckets = new ArrayList[sizeOfBuckets];
		for (int i = 0; i < myBuckets.length; i++) {
			myBuckets[i] = new ArrayList<>();
		}
		listHashCode = new ArrayList<>();
	}

	public int size() {
		return size;
	}

	private int hashFuntion(String key) {
		Objects.requireNonNull(key);
		key = key.trim();
		if (key.length() < 1) {
			throw new InputMismatchException("Length of key needed greater than 1");
		}
		int firstChar = key.charAt(0);
		int secondChar = ' ';
		if (key.length() > 1) {
			secondChar = key.charAt(1);
		}
		return firstChar * size8Bit + secondChar;
	}

	/**
	 * 
	 * @param key
	 * @return if ExpenseNote contains a mapping for the specified Key
	 */
	public boolean contrainsKey(String key) {
		Data data = new Data(key, 0);
		int hashCode = hashFuntion(key);
		var bucket = myBuckets[hashCode];
		if (bucket.contains(data)) {
			return true;
		}
		return false;
	}

	/**
	 * Associates the specified value with the specified key into this Expense Note
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Integer value) {
		Data data = new Data(key, value);
		int hashCode = hashFuntion(key);
		var bucket = myBuckets[hashCode];

		if (bucket.isEmpty()) {
			listHashCode.add(hashCode);
		}

		int indexInBucket = bucket.indexOf(data);
		if (indexInBucket < 0) { // not exist
			bucket.add(data);
			size++;
		} else {
			bucket.set(indexInBucket, data);
		}

	}

	/**
	 * 
	 * @param key
	 * @return the value to which the specified key is mapped, or null if this
	 *         Expense Note contains no mapping for the key
	 */
	public Integer get(String key) {
		Data data = new Data(key, 0);
		int hashCode = hashFuntion(key);
		var bucket = myBuckets[hashCode];
		int indexInBucket = bucket.indexOf(data);
		if (indexInBucket < 0) {
			return null;
		} else {
			return bucket.get(indexInBucket).getValue();
		}
	}

	/**
	 * Removes the mapping for a key from Expense Note if it's present
	 * 
	 * @param key
	 * @return the previous value associated with key, or null if there are no
	 *         mapping for the key
	 */
	public Integer remove(String key) {
		Data data = new Data(key, 0);
		int hashCode = hashFuntion(key);
		var bucket = myBuckets[hashCode];
		int indexOfData = bucket.indexOf(data);
		Integer oldValue = null;
		if (indexOfData < 0) {
			return oldValue;
		} else {
			oldValue = bucket.remove(indexOfData).getValue();
			size--;
		}
		if (bucket.isEmpty()) {
			listHashCode.remove(Integer.valueOf(hashCode));
		}
		return oldValue;
	}

	/**
	 * 
	 * @return List of Expenses
	 */
	public List<Data> getList() {
		List<Data> result = new ArrayList<Data>();
		for (int hashCode : listHashCode) {
			var bucket = myBuckets[hashCode];
			result.addAll(bucket);
		}
		return result;
	}

	/**
	 * 
	 * @param func
	 * @return List of Expenses after filter by Function
	 */
	public List<Data> getList(Function<Data, Boolean> func) {
		List<Data> result = new ArrayList<Data>();
		for (int hashCode : listHashCode) {
			var bucket = myBuckets[hashCode];
			for (Data data : bucket) {
				if (func.apply(data)) {
					result.add(data);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param comparator
	 * @return List of sorted Expense in order by Comparator
	 */
	public List<Data> getList(Comparator<Data> comparator) {
		List<Data> result = getList();
		result.sort(comparator);
		return result;
	}
}
