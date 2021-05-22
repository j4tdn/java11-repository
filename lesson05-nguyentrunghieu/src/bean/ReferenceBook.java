package bean;

public class ReferenceBook extends Book {
	private float tax;

	public ReferenceBook() {
	}

	public ReferenceBook(String id, int cost, String producer, float tax) {
		super(id, cost, producer);
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
		return "ReferenceBook [tax=" + tax + ", getId()=" + getId() + ", getCost()=" + getCost() + ", getProducer()="
				+ getProducer() + "]";
	}
}
