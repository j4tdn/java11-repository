package generic;

public interface IList<E> {
	int size();
	boolean isEmpty();
	boolean add(E t);
	boolean remove();
	E get(int i);
	void set(int i, E t);

}
