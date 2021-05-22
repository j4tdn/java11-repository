package exercise5;

public class ReferenceBook extends Book {
	private float tax;
	public ReferenceBook() {
	}
	public ReferenceBook(String id, float value, String publisher, float tax) {
		super(id, value, publisher);
		this.tax = tax;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}

	
}
