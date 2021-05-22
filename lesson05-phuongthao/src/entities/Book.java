package entities;

public abstract class Book {
	private Book bookCode;
	protected double price;
	private String publishing;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Book bookCode, double price, String publishing) {
		super();
		this.bookCode = bookCode;
		this.price = price;
		this.publishing = publishing;
	}

	public Book getBookCode() {
		return bookCode;
	}

	public void setBookCode(Book bookCode) {
		this.bookCode = bookCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	abstract double getMoney();

}
