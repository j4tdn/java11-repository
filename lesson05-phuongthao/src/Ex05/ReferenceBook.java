package Ex05;

public class ReferenceBook extends Book {
	private double tax;

	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String id, double cost, String publisher, double tax) {
		super(id, cost, publisher);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ">> " + tax;
	}

}
