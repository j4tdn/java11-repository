package exam5;

public class Book {
	private String bookId;
	private double bill;
	private String pubCompany;
	private String status;
	private double tax;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookId, double bill, String pubCompany, String status, double tax) {
		super();
		this.bookId = bookId;
		this.bill = bill;
		this.pubCompany = pubCompany;
		this.status = status;
		this.tax = tax;
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

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bill=" + bill + ", pubCompany=" + pubCompany + ", status=" + status
				+ ", tax=" + tax + "]";
	}
	
}
