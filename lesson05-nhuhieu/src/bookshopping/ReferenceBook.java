package bookshopping;

public class ReferenceBook {
	private String id;
	private String publishingCompany;
	private String tax;
	private double cost;
	
	public ReferenceBook() {
	}

	public ReferenceBook(String id, String publishingCompany, String tax, double cost) {
		this.id = id;
		this.publishingCompany = publishingCompany;
		this.tax = tax;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "ReferenceBook [id=" + id + ", publishingCompany=" + publishingCompany + ", tax=" + tax + ", cost="
				+ cost + "]";
	}
	
	
}
