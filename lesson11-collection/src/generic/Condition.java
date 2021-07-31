package generic;

@FunctionalInterface
public interface Condition<E> {
	boolean test(E e);
}
