package bai05;

public class STK extends Book{
	private double tax;
	
	public STK() {
		// TODO Auto-generated constructor stub
	}

	public STK(String idb, String pubcomp, double price, double tax) {
		super(idb, pubcomp, price);
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "STK [tax=" + tax + "]";
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
