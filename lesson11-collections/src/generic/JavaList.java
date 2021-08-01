package generic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JavaList<E> implements IList<E> {

	private int initialCapacity = 4;
	private int size;
	private E[] elements;

	public JavaList() {
		elements = create(initialCapacity);
	}

	public JavaList(int capacity) {
		if (capacity <= 0) {
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
	public boolean add(E e) {
		if (size < initialCapacity) {
			elements[size++] = e;
			return true;
		}

		elements = grow(e);
		return true;

		/*
		 * // new array E[] newElements = create(size + 1); for (int i = 0; i < size;
		 * i++) { newElements[i] = elements[i]; } newElements[size++] = e; elements =
		 * newElements; return true;
		 */
	}

	@Override
	public E remove(int i) {
		final Object[] es = elements;
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + "out of bounds");
		}
		@SuppressWarnings("unchecked")
		E oldElement = (E) es[i];
		fastRemove(es, i);
		return oldElement;
	}

	private void fastRemove(Object[] es, int index) {
		final int newSize = size - 1;
		for (int i = index; i < es.length - 1; i++) {
			es[i] = es[i + 1];
		}
		es[size = newSize] = null;
	}

	@Override
	public E get(int i) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + "out of bounds");
		}
		return elements[i];
	}

	@Override
	public void set(int i, E e) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + "out of bounds");
		}
		elements[i] = e;
	}

	@Override
	public int count(Condition<E> cond) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (cond.test(elements[i])) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(elements[i]);
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
		newElements[size++] = e;
		return newElements;
	}

	@Override
	public boolean remove(Object o) {
		final Object[] es = elements;
		final int size = this.size;
		int i = 0;
		found: {
			if (o == null) {
				for (; i < size; i++) {
					if (es[i] == null) {
						break found;
					}
				}
			} else {
				for (; i < size; i++) {
					if (o.equals(es[i])) {
						break found;
					}
				}
			}
			return false;
		}
		fastRemove(es, i);
		return true;
	}

}
