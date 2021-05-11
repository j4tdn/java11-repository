package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company company = new Company();
//		company.id = "";
		company.name = "";
//		company.address = "";
//		company.fund = 343;
		
		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}

}
