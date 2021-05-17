package ex04;

public class Employment extends People {

	@Override
	public double salary() {
		return (super.getHsl() + super.getHscv()) * 1250000;
	}
}
