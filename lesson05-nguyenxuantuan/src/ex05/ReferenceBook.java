package ex05;

public class ReferenceBook extends Book {
	private float tax;
	
	public ReferenceBook() {
		super();
	}
	
	public ReferenceBook(BookType type, String id, float price, String publisher, float tax) {
		super(type, id, price, publisher);
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
		return "ReferenceBook [tax=" + tax + "]";
	}
	
	@Override
	public float getLastPrice() {
		
		return this.price*(1+tax);
	}

}
