package immutable;

public class Ex01 {
	public static void main(String[] args) {
		String l1 = "hello";
		String l2 = "welcome";
		String l3 = "welcome";

		hash("l1", l1);
		hash("l2", l2);
		hash("l3", l3);
		System.out.println("============================");

		System.out.println("==============Immutable================");

		String i1 = new String("one");
		hash("i1", i1);

		i1 = new String("welcome");
		hash("i1", i1);
		String o1 = new String("hello");
		String o2 = new String("welcome");
		String o3 = new String("welcome");
		hash("o1", o1);
		hash("o2", o2);
		hash("o3", o3);
	}

	private static void hash(String text, String input) {
		System.out.println(text + ": " + System.identityHashCode(input));
	}
}
