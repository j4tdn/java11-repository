package company;

public class PeopleFactory {
	enum PeopleType {
		DIRECTOR,
		MANAGER,
		EMPLOYEE
	}
	
	public static People getPeople(PeopleType type) {
		People people = null;
		
		switch (type) {
		case DIRECTOR:
			people = createDirector();
			break;
		case MANAGER:
			people = createManager();
			break;
		case EMPLOYEE:
			people = createEmployee();
			break;

		default:
			people = new People();
		}
		
		return people;
	}
	
	private static Director createDirector() {
		return new Director();
	}
	
	private static Manager createManager() {
		return new Manager();
	}
	
	private static Employee createEmployee() {
		return new Employee();
	}
}
