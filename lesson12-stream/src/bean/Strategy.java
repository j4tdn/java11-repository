
package bean;

@FunctionalInterface
public interface Strategy<T> {
	boolean behavior(T t);
}