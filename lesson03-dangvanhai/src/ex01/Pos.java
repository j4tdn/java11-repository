package ex01;

public enum Pos {
	ONSIDE("TREN"), INSIDE("TRONG"), OUTSIDE("NGOAI");

	public final String value;

	private Pos(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
