package bai5;

public class SachGiaoKhoa {
	private String ms;
	private double price;
	private String nxb;
	private String status;
	
	public SachGiaoKhoa() {
	}

	public SachGiaoKhoa(String ms, double price, String nxb, String status) {
		this.ms = "SGK" + ms;
		this.price = price;
		this.nxb = nxb;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SachGiaoKhoa [ms=" + ms + ", price=" + price + ", nxb=" + nxb + ", status=" + status + "]";
	}
	
}

