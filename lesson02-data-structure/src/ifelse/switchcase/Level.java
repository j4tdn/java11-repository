package ifelse.switchcase;

public enum Level {
	GOOD("Gioi"),
	PRETTY_GOOD("Kha"),
	MEDIUM("Trung Binh"),
	BAD("Yeu");
	String value;
	Level(String value){
		this.value = value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hoc luc " + this.value;
	}
}
