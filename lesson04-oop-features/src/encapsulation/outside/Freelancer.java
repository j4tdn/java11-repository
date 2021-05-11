package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Deverloper;

public class Freelancer extends Deverloper{
	public static void main(String[] args) {
		Company comp = new Company();
		// comp.id = "mgm";
		 comp.name = "mgm";
		 //comp.fund = 100d;
		// comp.address = " pasteur";
		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}

}
