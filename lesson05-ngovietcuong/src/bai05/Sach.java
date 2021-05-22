package bai05;

public class Sach {
	private String maSach;
	private double donGia;
	private String nhaXB;

	public Sach() {
	}

	public Sach(String maSach, double donGia, String nhaXB) {
		super();
		this.maSach = maSach;
		this.donGia = donGia;
		this.nhaXB = nhaXB;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	@Override
	public String toString() {
		return maSach + " " + donGia + " " + nhaXB ;
	}

	
	
}
