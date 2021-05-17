package ex04;

public class Manager extends People {

	@Override
	public double salary() {
		return (super.getHsl() + super.getHscv()) * 2000000;
	}
}
