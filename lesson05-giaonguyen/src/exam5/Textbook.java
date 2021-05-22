package exam5;

public class Textbook extends Book {
	private String bookId;
	private double bill;
	private String pubCompany;
	private String status;
	
	public Textbook() {
		// TODO Auto-generated constructor stub
	}

	public Textbook(String bookId, double bill, String pubCompany, String status) {
		super();
		this.bookId = bookId;
		this.bill = bill;
		this.pubCompany = pubCompany;
		this.status = status;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public String getPubCompany() {
		return pubCompany;
	}

	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Textbook [bookId=" + bookId + ", bill=" + bill + ", pubCompany=" + pubCompany + ", status=" + status
				+ "]";
	}
	
}
