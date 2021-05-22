package entities;

public class ReferenceBook extends Book {

	private double tax;

	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(Book bookCode, double price, String publishing, double tax) {
		super(bookCode, price, publishing);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	double getMoney() {
		return (double) this.price * (1 + this.tax);
	}

}
