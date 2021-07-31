package generic;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("How are you");
		sequences.add("Enjoy our page");
		sequences.show();
		System.out.println("size: " + sequences.size());

		Condition<String> cond1 = new Condition<String>() {

			@Override
			public boolean test(String e) {
				return e.startsWith("how");
			}
		};

		int count = sequences.count(cond1);
		count = sequences.count(e -> e.startsWith("How"));
		System.out.println("count: " + count);

		int countFilter = sequences.countFilter(e -> e.startsWith("En"));
		System.out.println("count Filter: " + countFilter);

		sequences.add("Monkey");
		String removed = sequences.remove(sequences.size() - 1);
		System.out.println("Removed element: " + removed);
		System.out.println("size: " + sequences.size());

	}
}
