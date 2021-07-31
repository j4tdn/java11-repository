package generic;

import java.lang.reflect.Array;

public class JavaList<E> implements IList<E> {

	private int initialCapacity = 4;
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

	@SuppressWarnings("unchecked")
	public E[] create(int size) {
		return (E[]) Array.newInstance(Object.class, size);
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
	public boolean add(E e) {
		if (size < initialCapacity) {
			elements[size++] = e;
			return true;
		}
			E[] newElements = create(size + 1);
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		newElements[size++] = e;
		elements = newElements;
		return true;
	}

	@Override
	public boolean remove(int i) {

		return false;
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
			System.out.println(elements[i]);
		}

	}
	@Override
	public int count(condition<E> e) {
		int count =0;
		for(int i =0; i<size; i++) {
			if(e.test(elements[i])) {
				count++;
			}
		}
		return count;
	}

	

}
