package encapsulation.insde;

public class Employee {
	public static void main(String[] args) {
		Company company = new Company();
		// company.id = "mgm"; // private F
		company.name = "mgm"; // public T
		company.fund = 100d; // protected T
		company.address = "pauster"; // default T
	}
}
