package ex04;

public class Director extends People{
	private float positionCoefficient;

	public Director() {
		super();
	}

	public Director(String name, String yearOfBirth, float coefficientSalary, float positionCoefficient) {
		super(name, yearOfBirth, coefficientSalary);
		this.positionCoefficient = positionCoefficient;
	}

	public float getPositionCoefficient() {
		return positionCoefficient;
	}

	public void setPositionCoefficient(int positionCoefficient) {
		this.positionCoefficient = positionCoefficient;
	}

	@Override
	float getSalary() {
		return (this.positionCoefficient + this.coefficientSalary) * 1250000;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ ", position coefficient: " + this.positionCoefficient;
	}
}