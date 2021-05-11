package encapsulation.outside;

import encapsulation.inside.Company;
import encapsulation.inside.Deleloper;


// sub class
public class Freelance extends Deleloper {
	public static void main(String[] args) {
			Company company = new Company();
			//company.id;
			//company.address;
			company.name= " aaa";
			//company.fund;
			
			Freelance f1 = new Freelance();
			f1.getSkill();
			
	}
}
