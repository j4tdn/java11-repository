package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

//subclass
public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company comp = new Company();
		//comp.id = "mgm";
		comp.name = "mgm";
		//comp.fund = 100d;
		//comp.address = "abc";
		
		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}
}
