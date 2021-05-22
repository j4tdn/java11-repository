package exam5;

public class RefBook extends Book {
	
	private String bookId;
	private double bill;
	private String pubCompany;
	private double tax;

	public RefBook() {
		// TODO Auto-generated constructor stub
	}
	
	public RefBook(String bookId, double bill, String pubCompany, double tax) {
		super();
		this.bookId = bookId;
		this.bill = bill;
		this.pubCompany = pubCompany;
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

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "RefBook [bookId=" + bookId + ", bill=" + bill + ", pubCompany=" + pubCompany + ", tax=" + tax + "]";
	}
	
	
}
