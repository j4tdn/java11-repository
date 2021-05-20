package ex04;

public class Director extends People {
	private float coRespon;

	
	

	public Director(String name, int yearOfBirth, float coEffiencts, float coRespon) {
		super(name, yearOfBirth,coEffiencts);
		this.coRespon = coRespon;
	}


	public float getCoRespon() {
		return coRespon;
	}


	public void setCoRespon(float coRespon) {
		this.coRespon = coRespon;
	}


	float getSalary() {
		return (coRespon * this.getCoEffiencts())* 3000000;
	}


	@Override
	public String toString() {
		return super.toString()
				+ " " + this.getCoEffiencts() + coRespon;
	}
	
	
	
	
}
