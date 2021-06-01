package encapsultion.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

// subclass
public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company comp = new Company();
		// comp.id = "mgm";   // private F
		comp.name = "mgm"; // public  T
		// comp.fund = 100d;  // protected F
		// comp.address = "pasteur"; // default F
		
		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}
	
}
