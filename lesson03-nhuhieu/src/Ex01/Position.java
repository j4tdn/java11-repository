package Ex01;

public enum Position {
	INSIDE("Inside circle"), ONSIDE("Onside circle"), OUTSIDE("Outside circle");

	public String value;

	Position(String value) {
		this.value = value;
	}

}
