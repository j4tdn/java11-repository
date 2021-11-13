package enumeration;

public enum Position {
	INSIDE("Trong đường tròn"),
	ONSIDE("Trên đường tròn"),
	OUTSIDE("Ngoài đường tròn");
	
	public String value;
	
	Position(String value){
		this.value=value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}