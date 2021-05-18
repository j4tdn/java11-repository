package ex04;

import ex04.PeopleFactory.PeopleType;

public class App {
	public static void main(String[] args) {
		People p1 = PeopleFactory.getPeople(PeopleType.EMPLOYMENT);
		PeopleUtils.inputPeople(p1);

		People p2 = PeopleFactory.getPeople(PeopleType.MANAGER);
		PeopleUtils.inputPeople(p2);

		People p3 = PeopleFactory.getPeople(PeopleType.DIRECTOR);
		PeopleUtils.inputPeople(p3);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	
	}
}
