package bai02;

public class Customer {
	private String tenChuXe;

	public Customer() {
	}

	public Customer(String tenChuXe) {
		super();
		this.tenChuXe = tenChuXe;
	}

	public String getTenChuXe() {
		return tenChuXe;
	}

	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}

	@Override
	public String toString() {
		return tenChuXe +"\t";
	}

}
