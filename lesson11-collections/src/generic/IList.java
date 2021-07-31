package generic;

import java.util.function.Predicate;

public interface IList<E> {
	int size();

	boolean isEmpty();

	void add(E e);

	E remove(int i);

	E get(int i);

	void set(int i, E e);

	void show();

	int count(Condition<E> condition);

	int countFilter(Predicate<E> cond);
}
