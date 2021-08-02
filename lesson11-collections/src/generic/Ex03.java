package generic;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("How are you");
		sequences.add("Enjoy our page");
		sequences.add("First commit");
		sequences.add("Change your life");
		sequences.add("Passed mission");
		sequences.add("Narration voice");
		sequences.add("Mandela effect");
		sequences.add("Little Caesar");
		sequences.show();
		System.out.println("size: " + sequences.size());

		Condition<String> cond1 = new Condition<String>() {

			@Override
			public boolean test(String e) {
				return e.startsWith("how");
			}
		};

		int count = sequences.count(cond1);
		System.out.println("count: " + count);

		int countFilter = sequences.countFilter(e -> e.startsWith("En"));
		System.out.println("count Filter: " + countFilter);

		String removed = sequences.remove(sequences.size() - 1);
		System.out.println("Removed element: " + removed);
		System.out.println("size: " + sequences.size());

	}
}
