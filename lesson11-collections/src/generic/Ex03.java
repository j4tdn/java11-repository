package generic;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("how are you");
		sequences.add("enjoy our page");
		sequences.add("stay safe and take care");
		sequences.add("stay safe and take care");
		sequences.add("stay safe and take care");

		
		System.out.println("size: " + sequences.size());
		sequences.show();
		System.out.println(sequences.count(e -> e.startsWith("stay")));
	}
}
