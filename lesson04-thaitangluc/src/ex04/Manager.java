package ex04;

public class Manager extends People{
	private String name;
	private int yearOB;
	private double coSalary;
	private double coPosition; 
	
	public Manager() {
		
	}
	public Manager(String name, int yearOB, double coSalary, double coPosition) {
		super(name, yearOB, coSalary);
		this.coPosition = coPosition;
	}
	public double getCoPosition() {
		return coPosition;
	}
	public void setCoPosition(double coPosition) {
		this.coPosition = coPosition;
	}
	@Override
	public String toString() {
		return "Manager [name=" + name + ", yearOB=" + yearOB + ", coSalary=" + coSalary + ", coPosition=" + coPosition
				+ "]";
	}
	 
	
	
	
	
}
