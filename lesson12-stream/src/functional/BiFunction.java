package functional;

@FunctionalInterface
public interface BiFunction <T, R, S>{
	T get (R r, S s);
}

