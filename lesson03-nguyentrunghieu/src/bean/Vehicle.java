package bean;

public class Vehicle {
	private String chuXe;
	private String loaiXe;
	private int dungTich;
	private long triGia;
	private double thue;
	
	public Vehicle() {
	}

	public Vehicle(String chuXe, String loaiXe, int dungTich, long triGia) {
	
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	public String getChuXe() {
		return chuXe;
	}

	public void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public int getDungTich() {
		return dungTich;
	}

	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}

	public long getTriGia() {
		return triGia;
	}

	public void setTriGia(long triGia) {
		this.triGia = triGia;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}
	@Override
	public String toString() {
		return "Vehicle [chuXe=" + chuXe + ", loaiXe=" + loaiXe + ", dungTich=" + dungTich + ", triGia=" + triGia
				+ ", thue=" + thue + "]";
	}
}
