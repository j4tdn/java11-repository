package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

public class Freelancer extends Developer {
public static void main(String[] args) {
//	Company comp = new Company();
//	comp.id = "mgm";	//f 
//	comp.name = "mgm";	//t
//	comp.fund = 9d;		//f
//	comp.address = "mgm";//f
	Freelancer f1 = new Freelancer();
	f1.getSkill();
}
}
