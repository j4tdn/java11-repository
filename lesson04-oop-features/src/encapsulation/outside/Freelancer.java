package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company company = new Company();
		Freelancer freelancer = new Freelancer();
		freelancer.getSkills();
	}
}
