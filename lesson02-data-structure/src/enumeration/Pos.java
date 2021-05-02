package enumeration;

public enum Pos {
	INSIDE("Trong"), OUTSIDE("Ngoai"), ONSIDE("Tren");

	public String value;
	
	//Constructor: private default access modifier
	Pos(String value) {
		this.value = value;
	}
}
