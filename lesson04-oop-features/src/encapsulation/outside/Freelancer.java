package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Developer;

public class Freelancer extends Developer {
	Company comp = new Company();
	//comp.id="mgm" //private F
	//comp.name = "mgm"; //public T
	//comp.fund=100d; //protected F
	//comp.address="pasteur" //defaulf F
	
	Freelancer f1=new Freelancer();
	//f1.getSkills();
}
