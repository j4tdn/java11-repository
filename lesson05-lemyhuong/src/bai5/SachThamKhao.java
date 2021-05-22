package bai5;

public class SachThamKhao {
	private String ms;
	private double price;
	private String nxb;
	private double tax;
	
	public SachThamKhao() {
	}

	public SachThamKhao(String ms, double price, String nxb, double tax) {
		this.ms = "STK" + ms;
		this.price = price;
		this.nxb = nxb;
		this.tax = tax;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "SachThamKhao [ms=" + ms + ", price=" + price + ", nxb=" + nxb + ", tax=" + tax + "]";
	}
	
	
}
