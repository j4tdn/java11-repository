package generic;

import java.lang.reflect.Array;
import java.util.function.Predicate;


public class JavaList<E> implements IList<E> {

	private int initialCapacity = 10;
	private E[] elements;
	private int size;
	
	public JavaList() {
	 elements = create(initialCapacity);
	 }
	
	public JavaList( int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException("Capacity should be geater than 0");			
		}
		if(capacity > initialCapacity) {
			initialCapacity = capacity;
		}
		elements = create(capacity< initialCapacity ? initialCapacity: capacity);
	}
	//note
	@SuppressWarnings("unchecked")
	public E[] create(int size) {
		return (E[])Array.newInstance(Object.class, size);
	}
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {	
		
		return size == 0;
	}

	@Override
	public boolean add(E e) {
		if(size < initialCapacity) {
			elements[size++] = e;
			return true;
		}
		elements = grow(e);
		return true;
	}

	@Override
	public boolean remove() {
		return false;
	}

	@Override
	public E get(int i) {
		if(i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + "out of bounds exception");
		}
		return elements[i];
	}

	@Override
	public void set(int i, E t) {
		if( i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException("Index " + i + "out of bounds exception");
		}
		elements[i] = t;
	}

	@Override
	public void show() {
		 for(int i = 0; i< size; i++) {
			 System.out.println(elements[i]);
		 }
	}
	private E[] grow(E e) {
		E[] newElements = create(size +1);
		for(int i = 0; i< size; i++) {
			newElements[i] = elements[i];
		}
		return newElements;
		
	}

	@Override
	public int count(Predicate<E> cond) {
		int count = 0;
		for(int i = 0; i< size; i++) {
			if(cond.test(elements[i])) {
				count++;
			}
		}
		return count;
	}
 
	
	

}
