package encapsulation_outside;

import encapsulation_inside.Company;
import encapsulation_inside.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {

		Company comp = new Company();
		//comp.id = "mgm"; // private: F
		comp.name = "mgm"; // public: T
		//comp.fund = 10.0d; // protected: F
		//comp.address = "dn"; // default: F
		
		Freelancer f1 = new Freelancer();
		f1.getSkill();
	}
}
