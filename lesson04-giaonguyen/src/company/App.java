package company;

import company.PeopleFactory.PeopleType;

public class App {
	public static void main(String[] args) {
		
		//input
		People d1 = PeopleFactory.getPeople(PeopleType.DIRECTOR);
		d1.inputInfo();
		System.out.println("=====================");
		People m1 = PeopleFactory.getPeople(PeopleType.MANAGER);
		m1.inputInfo();
		System.out.println("=====================");
		People e1 = PeopleFactory.getPeople(PeopleType.EMPLOYEE);
		e1.inputInfo();
		System.out.println("=====================");
		People e2 = PeopleFactory.getPeople(PeopleType.EMPLOYEE);
		e2.inputInfo();
		System.out.println("=====================");
		
		//output
		System.out.printf("Salary of director: %s", CompanyUtils.exportSalary(d1));
		System.out.printf("\nSalary of manager: %s", CompanyUtils.exportSalary(m1));
		System.out.printf("\nSalary of employee 1: %s", CompanyUtils.exportSalary(e1));
		System.out.printf("\nSalary of employee 2: %s", CompanyUtils.exportSalary(e2));
		
	}
}
