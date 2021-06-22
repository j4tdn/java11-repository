package hashutils;

public class JvmUtils{
	private JvmUtils() {
		
	}
	public static void hash(String text, CharSequence s) {
		System.out.println(System.identityHashCode( s));;
		
	}
}