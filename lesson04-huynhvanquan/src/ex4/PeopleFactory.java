package ex4;

public class PeopleFactory {
	enum PosType {
		DIRECTOR, HEADOFDEPARMENT, STAFF
	}
	private PeopleFactory() {}
	public static People getPoeple(PosType type) {
		People people = null;
		switch(type) {
		case DIRECTOR:
			people = createDirector();
			break;
		
		case HEADOFDEPARMENT:
			people = createHeadOfDepartment();
			break;
		case STAFF:
			people = createStaff();
			break;
		default:
			people = new People();
		}
		return people;
	}
	public static Director createDirector() {
		return new Director();
	}
	public static HeadOfDepartment createHeadOfDepartment() {
		return new HeadOfDepartment();
	}
	public static Staff createStaff() {
		return new Staff();
	}
}
