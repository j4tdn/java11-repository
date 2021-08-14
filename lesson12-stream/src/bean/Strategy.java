package bean;

public interface Strategy<T> {
	// dung lamda thi chi co 1 ham truu tuong functional interface
	  boolean behavior(T t) ;
	  
	  
}
