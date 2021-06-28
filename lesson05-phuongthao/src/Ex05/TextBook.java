package Ex05;

public class TextBook extends Book {
	private Status status;

	public TextBook() {
		// TODO Auto-generated constructor stub
	}

	public TextBook(String id, double cost, String publisher, Status status) {
		super(id, cost, publisher);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ">> " + status;
	}

}
