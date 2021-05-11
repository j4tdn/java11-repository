package encapsulation_inside;

public class Employee {
	public static void main(String[] args) {
		Company comp = new Company();
		// comp.id = "mgm"; // private: F
		comp.name = "mgm"; // public: T
		comp.fund = 10.0d; // protected: T
		comp.address = "dn"; // default: T
	}
}
