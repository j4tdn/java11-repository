package ex02;

public class Register {
	private Customer customer;
	private Vehicle name;
	
	public Register() {
		// TODO Auto-generated constructor stub
	}

	public Register(Customer customer, Vehicle name) {
		super();
		this.customer = customer;
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getName() {
		return name;
	}

	public void setName(Vehicle name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return customer +"\t\t" + name + "\t";
	}
	
}
