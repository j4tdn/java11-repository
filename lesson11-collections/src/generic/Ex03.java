package generic;

public class Ex03 {
	public static void main(String[] args) {
		IList<String> sequences = new JavaList<>();
		sequences.add("how are you1");
		sequences.add("enjoy our page1");
		sequences.add("how are you2");
		sequences.add("enjoy our page2");
		sequences.add("how are you3");
		sequences.add("enjoy our page3");

//		System.out.println("size = " + sequences.size());
//		System.out.println("get(i) = " + sequences.get(5));
//		sequences.show();
//
//		System.out.println("count : " + sequences.count(x -> x.startsWith("how")));

		System.out.println("item remove: " + sequences.remove("enjoy our page2"));
		System.out.println("item remove: " + sequences.remove("enjoy our page"));
		System.out.println("item remove: " + sequences.remove("enjoy our page3"));
		System.out.println("item remove: " + sequences.remove("how are you3"));
		sequences.show();
	}
}
