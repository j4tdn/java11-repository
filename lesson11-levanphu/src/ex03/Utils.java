package ex03;
import java.util.Collection;

public class Utils {
	private Utils() {
	}
	
	public static <E> void printf(Collection<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
		
	}
}
