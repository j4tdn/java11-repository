package encapsulation.inside;

public class Employee {
	public static void main(String[] args) {
		Company comp = new Company();
		// comp.id = "mgm";   // private F
		comp.name = "mgm"; // public  T
		comp.fund = 100d;  // protected T 
		comp.address = "pasteur"; // default T
	}
}
