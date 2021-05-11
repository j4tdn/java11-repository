package encapsulationinside;

public class Employee {
	public static void main(String[] args) {
		Company company = new Company();
		//company.id = "mgm"; // private
		company.name = "mgm"; // public
		company.fun = 100d ; // protected
		company.address = "pasteur";//default
	}
}
