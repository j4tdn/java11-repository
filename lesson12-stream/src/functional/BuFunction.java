package functional;

@FunctionalInterface
public interface BuFunction<T,R, S, M, N> {
	//truyen vao T tra ve R,S,M,N
	T get(R r, S s, M m, N n);
}
