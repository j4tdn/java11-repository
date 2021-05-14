package ex01_circle;

public enum Pos {
	INSIDE ("Diem nam trong duong tron"),
	OUTSIDE ("Diem nam ngoai duong tron"),
	ONSIDE ("Diem nam tren duong tron");
	
	String value;
	
	Pos(String value) {
		this.value = value;
	}
	
}
