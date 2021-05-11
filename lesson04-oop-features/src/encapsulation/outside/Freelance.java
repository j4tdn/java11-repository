package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Develop;

public class Freelance extends Develop {
	public static void main(String[] args) {
		Company comp = new Company();
		
		//comp.id = "mgm";
		comp.name = "mgm";
		//comp.fund = 100d;
		//comp.address = "pasteur";
		 
		Freelance f1 = new Freelance();
		f1.getSkill();
	}
}
