package bean;

public class TextBook extends Book {
	private boolean status;

	public TextBook() {
	}

	public TextBook(String id, int cost, String producer, boolean status) {
		super(id, cost, producer);
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TextBook [status=" + status + ", getId()=" + getId() + ", getCost()=" + getCost() + ", getProducer()="
				+ getProducer() + "]";
	}
}
