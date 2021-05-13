package ex04;

public class Vehicle {
	public String peopleName;
	private String carName;
	private int cc;
	private long price;
	private long tax;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String peopleName, String carName, int cc, long price) {
		super();
		this.peopleName = peopleName;
		this.carName = carName;
		this.cc = cc;
		this.price = price;
		this.tax = tax(cc,price);
	}

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Vehicle [peopleName=" + peopleName + ", carName=" + carName + ", cc=" + cc + ", price=" + price
				+ ", tax=" + tax + "]";
	}
	
	public static long tax(int cc, long price) {
		long tax =0;
		if (cc < 100) {
			return tax = (long) (price*0.01);	
		} else if(cc < 200) {
			return tax =(long) (price*0.03);
		}
		return tax =(long) (price*0.05);
	}
}
