package generic;

import java.lang.reflect.Array;
import java.util.function.Predicate;

public class JavaList<E> implements IList<E> {

	private int initialCapacity = 5;
	private int size;
	private E[] elements;

	public JavaList() {
		elements = create(initialCapacity);
	}

	public JavaList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity should be greater than 0");
		}

		if (capacity > initialCapacity) {
			initialCapacity = capacity;
		}

		elements = create(initialCapacity);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void add(E e) {
		if (size < initialCapacity) {
			elements[size++] = e;
		}

		// new array
		elements = grow(e);
	}

	@Override
	public E remove(int i) {
		if (i < 0 | i >= size) {
			throw new ArrayIndexOutOfBoundsException("Array index out of range [0," + (size - 1) + "]");
		}
		E removedElement = elements[i];

		// Copy the elements be not removed to new Array
		E[] newElements = create(--size);
		for (int index = 0; index < i; index++) {
			newElements[index] = elements[index];
		}
		for (int index = i; index < size; i++) {
			newElements[index] = elements[i + 1];
		}

		// Save to my list
		elements = newElements;

		// return the removed element
		return removedElement;
	}

	@Override
	public E get(int i) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds exception");
		}
		return elements[i];
	}

	@Override
	public void set(int i, E e) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds exception");
		}
		elements[i] = e;
	}

	@Override
	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(elements[i] + " ");
		}
	}

	@SuppressWarnings("unchecked")
	private E[] create(int size) {
		return (E[]) Array.newInstance(Object.class, size);
	}

	private E[] grow(E e) {
		E[] newElements = create(size + 1);
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		newElements[size] = e;
		return newElements;
	}

	@Override
	public int count(Condition<E> condition) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (condition.test(elements[i])) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int countFilter(Predicate<E> cond) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (cond.test(elements[i])) {
				count++;
			}
		}
		return count;
	}

}
