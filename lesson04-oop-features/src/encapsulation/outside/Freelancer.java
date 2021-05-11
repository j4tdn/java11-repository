package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company company = new Company();

		// company.id = "mgm";
		company.name = "mgm";
		// company.fund = 100d;
		// company.address = "pasteur";

		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}

}
