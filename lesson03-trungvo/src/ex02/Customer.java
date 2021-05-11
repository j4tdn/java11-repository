package ex02;

public class Customer {
	private String customer;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customer) {
		super();
		this.customer = customer;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return customer ;
	}
	
	
}
