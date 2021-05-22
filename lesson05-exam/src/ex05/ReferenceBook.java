package ex05;

public class ReferenceBook extends Book {
	private double tax;

	public ReferenceBook(String idBook, double price, String publisher, double tax) {
		super("STK" + idBook, price, publisher);
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferenceBook [" + super.toString() + "tax=" + tax + "]";
	}

}