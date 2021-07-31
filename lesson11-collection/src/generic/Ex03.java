package generic;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("hello");
		sequences.add("what's up");
		sequences.add("hello");
		sequences.add("what's up");
		
		System.out.println("size: " + sequences.size());
		
		sequences.show();
		
		System.out.println("count: " + sequences.count(e -> e.startsWith("hello")));
	}
}
