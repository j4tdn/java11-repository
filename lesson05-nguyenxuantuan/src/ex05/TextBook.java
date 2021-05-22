package ex05;

public class TextBook extends Book{
	
	private String status;
	
	public TextBook() {
		super();
	}
	
	public TextBook(BookType type, String id, float price, String publisher, String status) {
		super(type, id, price, publisher);
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
		return super.toString() + ", status: " + status;
	}

	@Override
	public float getLastPrice() {
		if(this.status.equalsIgnoreCase("cu")) {
			return this.price * 0.7f;
		} else {
			return this.price;
		}
	}
	

}
