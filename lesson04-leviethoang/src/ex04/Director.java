package ex04;

public class Director extends People {

	@Override
	public double salary() {
		return (super.getHsl() + super.getHscv()) * 3000000;
	}
}
