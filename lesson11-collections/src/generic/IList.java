package generic;

import java.util.function.Predicate;

public interface IList<E> {
	int size();
	boolean isEmpty();
	boolean add(E t);
	boolean remove(int i);
	E get(int i);
	void set(int i, E t);
	void show();
	int count(Predicate<E> condition);
}
