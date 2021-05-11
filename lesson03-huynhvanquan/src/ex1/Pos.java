package ex1;

public enum Pos {
	INSIDE("Inside round"), 
	ONSIDE("Onside round"), 
	OUTSIDE("Outside round");

	public String value;

	Pos(String value) {
		this.value = value;
	}

}
