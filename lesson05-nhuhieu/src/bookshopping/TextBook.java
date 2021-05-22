package bookshopping;

public class TextBook {
	private String id;
	private String publishingCompany;
	private String status;
	private double cost;

	public TextBook() {
	}

	public TextBook(String id, String publishingCompany, String status, double cost) {
		this.id = id;
		this.publishingCompany = publishingCompany;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "TextBook [id=" + id + ", publishingCompany=" + publishingCompany + ", status=" + status + ", cost="
				+ cost + "]";
	}

	
	}
	
	

