package ex05;

public class TextBook extends Book {
	private boolean isNew;

	public TextBook() {
	}

	public TextBook(String idBook, double price, String publisher, boolean isNew) {
		super(idBook, price, publisher);
		this.isNew = isNew;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public String toString() {
		return "TextBook [" + super.toString() + ", isNew=" + isNew + "]";
	}

	@Override
	public double calPricePay() {
		if (!this.isNew) {
			return getPrice() * 30 / 100;
		}
		return getPrice();
	}

}
