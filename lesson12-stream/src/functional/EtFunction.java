package functional;

@FunctionalInterface
public interface EtFunction <T, R, S> {
	T get(R r, S s);
}
