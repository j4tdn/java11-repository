package entities;

public class TextBook extends Book {

	private String status;

	public TextBook() {
		// TODO Auto-generated constructor stub
	}

	public TextBook(Book bookCode, double price, String publishing, String status) {
		super(bookCode, price, publishing);
		this.status = status;
	}

	@Override
	double getMoney() {
		if (this.status == "moi") {
			return this.price;
		}
		return 0.3 * this.price;

	}

}
