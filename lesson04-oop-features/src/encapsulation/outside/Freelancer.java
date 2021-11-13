package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company comp = new Company();
		comp.id = 123;
		// comp.name = "mgm";
		// comp.address ="Pasteur";
		// comp.fund
		Freelancer fr = new Freelancer();
		fr.getItSkills();

	}
	@Override
	protected String getItSkills() {
		return "HTML,CSS,SCSS,JS";
	}
}
