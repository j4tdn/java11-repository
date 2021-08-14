package bean;

@FunctionalInterface
public interface Strategy<T> {
	 boolean test(T t);
}