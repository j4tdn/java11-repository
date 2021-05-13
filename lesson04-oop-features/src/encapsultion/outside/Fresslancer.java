package encapsultion.outside;

import encapsultion.inside.Company;
import encapsultion.inside.Developer;

public class Fresslancer extends Developer {
	public static void main(String[] args) {
		Company comp = new Company();
		
		comp.name = "mgm";
		Fresslancer f1 = new Fresslancer();
		f1.getSkill();
	}

}
