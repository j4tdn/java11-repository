package ex05;

public class ReferBook extends Book {
	private float tax;

	public ReferBook() {
	}

	public ReferBook(String idBook, double price, String publisher, float tax) {
		super(idBook, price, publisher);
		this.tax = tax;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferBook [" + super.toString() + ", tax=" + tax + "]";
	}

	@Override
	public double calPricePay() {
		return getPrice() * (1 + tax);
	}
}
