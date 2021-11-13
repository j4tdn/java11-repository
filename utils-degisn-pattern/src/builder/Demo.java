package builder;

public class Demo {
	
		public static void main(String[] args) {
			Person p1 = Person.builder().setAge(19).setFirstName("khoa").setAge(20).build();
			
			System.out.println(p1);
		}
}
