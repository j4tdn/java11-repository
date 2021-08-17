package generic;

import java.util.function.Predicate;

public interface IList<E> {
	int size();
	boolean isEmpty();
	boolean add(E e);
	boolean remove(int i);
	E get(int i);
	void set(int i, E e);
	void show();
	E[] grow(E e);
	int count(Predicate<E> cond);
}