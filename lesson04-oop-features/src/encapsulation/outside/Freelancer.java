package encapsulation.outside;

import encapsulation.insde.Company;
import encapsulation.insde.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company company = new Company();
		// company.id = "mgm"; // private F
		company.name = "mgm"; // public T
		// company.fund = 100d; // protected F
		// company.address = "pauster"; // default F

		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}
}
