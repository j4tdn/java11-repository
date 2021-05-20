package ex04;

public class Manager extends People{
	private int numberOfStaff;
	
	public Manager() {
		super();
	}
	public Manager(String name, int yearOfBirth, float coEffiencts, int numberOfStaff) {
		super(name, yearOfBirth,  coEffiencts);
		this.numberOfStaff = numberOfStaff;
		}
	public int getNumberOfStaff() {
		return numberOfStaff;
	}
	public void setNumberOfStaff(int numberOfStaff) {
		this.numberOfStaff = numberOfStaff;
	}
	
	@Override
	float getSalary() {
		return (this.getCoEffiencts())*2200000;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + this.getCoEffiencts() + this.numberOfStaff;
	}
	
	
	
}
