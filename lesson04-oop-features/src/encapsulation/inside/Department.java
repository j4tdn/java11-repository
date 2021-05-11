package encapsulation.inside;

public class Department {
	public static void main(String[] args) {
		Company comp = new Company();
		//comp.id = "mgm"; //private
		comp.name = "mgm";
		comp.fund = 100d;
		comp.address = "abc";
	}
}
