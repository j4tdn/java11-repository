package data;

public class Digit {
	public int value;
	public Digit(int value)
	{
		this.value=value;
	}
	@Override
	public String toString() {
		return "Value:" + this.value;
	}

}