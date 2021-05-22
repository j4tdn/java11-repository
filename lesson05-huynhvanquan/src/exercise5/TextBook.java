package exercise5;

public class TextBook extends Book {
	private boolean status;
	public TextBook() {};
	public TextBook(String id, float value, String publisher, boolean status) {
		super(id, value, publisher);
		this.status = status;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
