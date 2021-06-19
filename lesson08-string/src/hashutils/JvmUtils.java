package hashutils;

public class JvmUtils{
	private JvmUtils() {
		
	}
	public static void hash(String l1) {
		System.out.println(System.identityHashCode(l1));;
		
	}
}