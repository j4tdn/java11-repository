package generic;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("how are you");
		sequences.add("enjoy your page");
		sequences.add("how are you");
		sequences.add("enjoy your page");
		sequences.add("how are you");
		sequences.show();
		System.out.println("size: " + sequences.size());
		System.out.println(sequences.count(e -> e.startsWith("how")));

		
	}
}