package ex04;

public class PeopleFactory {
	enum PeopleType {
		EMPLOYMENT, MANAGER, DIRECTOR
	}

	private PeopleFactory() {

	}

	public static People getPeople(PeopleType type) {
		People people = null;
		switch (type) {
		case EMPLOYMENT:
			people = createEmployment();
			break;
		case MANAGER:
			people = createManager();
			break;
		case DIRECTOR:
			people = createDirector();
			break;
		default:
			people = new People();
		}
		return people;
	}

	private static People createEmployment() {
		return new Employment();
	}

	private static People createManager() {
		return new Manager();
	}

	private static People createDirector() {
		return new Director();
	}
}
