package functional;

@FunctionalInterface
public interface Calculator<T> {
	T perform(T a, T b);
}
