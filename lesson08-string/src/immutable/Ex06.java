package immutable;

public class Ex06 {
	public static void main(String[] args) {
		// Print: 102-190-789-228
		
		String[] ids = {"102", "190", "789", "228"};
		System.out.println(String.join("-", ids));
		
		printf("111", "222", "333");
	}
	
	// ... variables
	private static void printf(String... ids) {
		for(String id: ids) {
			System.out.println(id);
		}
	}
}
