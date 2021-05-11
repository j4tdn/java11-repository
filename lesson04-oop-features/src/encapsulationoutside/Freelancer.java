package encapsulationoutside;

import encapsulationinside.Company;
import encapsulationinside.Developer;

public class Freelancer extends Developer {
	public static void main(String[] args) {
		Company company = new Company();
		//company.id = "mgm"; // private
		company.name = "mgm"; // public
		//company.fun = 100d ; // protected
		//company.address = "pasteur";//default
		
		Freelancer f1 = new Freelancer();
		f1.getSkill();
	}
}
