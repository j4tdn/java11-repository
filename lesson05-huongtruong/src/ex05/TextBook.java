package ex05;

public class TextBook extends Book {
	private String status;

	public TextBook(String idBook, double price, String publisher, String status) {
		super("SGK" + idBook, price, publisher);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TextBook [" + super.toString() + "status=" + status + "]";
	}

}