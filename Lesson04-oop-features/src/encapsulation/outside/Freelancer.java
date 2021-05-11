package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

// subclass
public class Freelancer extends Developer { //Freelancer la con, Developer la cha
	public static void main(String[] args) {
		Company comp = new Company();
//		comp.id = "mgm"; //private => False
		comp.name = "mgm"; // public => True
//		comp.fund = 100d; //protected => False
//		comp.address = "passteur"; //default => False
		
		Freelancer f1 = new Freelancer();
		f1.getSkills();
	}
}
