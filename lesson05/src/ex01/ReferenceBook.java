package ex01;

public class ReferenceBook extends Book{
	private double tax;
	public ReferenceBook(String id ,int b, String c, int d) {
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public ReferenceBook(double tax) {
		super();
		this.tax = tax;
	}
	@Override
	public String toString() {
		return "ReferenceBook [tax=" + tax + "]";
	}
	
	
	

	
}
