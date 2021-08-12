package bean;

@FunctionalInterface //la ham chi co duy nhat 1 ham truu tuong
public interface Strategy<T> {
	boolean behavior(T t);
	
}
