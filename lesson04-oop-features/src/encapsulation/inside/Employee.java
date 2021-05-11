package encapsulation.inside;

public class Employee {
	public static void main(String[] args) {
		Company comp = new Company();
//		comp.id = "mgm"; //private => False
		comp.name = "mgm"; // public => True
		comp.fund = 100d; //protected => True
		comp.address = "passteur"; //default => True
		
	}
}
