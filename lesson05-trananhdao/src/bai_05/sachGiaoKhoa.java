package bai_05;

public class sachGiaoKhoa {
	private String maSGK;
	private double donGia;
	private String NXB;
	private String tinhtrang;
	public sachGiaoKhoa() {
		// TODO Auto-generated constructor stub
	}
	public sachGiaoKhoa(String maSGK, double donGia, String nXB, String tinhtrang) {
		super();
		this.maSGK = maSGK;
		this.donGia = donGia;
		NXB = nXB;
		this.tinhtrang = tinhtrang;
	}
	public String getMaSGK() {
		return maSGK;
	}
	public void setMaSGK(String maSGK) {
		this.maSGK = maSGK;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getNXB() {
		return NXB;
	}
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	public double TinhthanhtienSGK() {
		if(tinhtrang.equals("cu")) {
			return donGia*0.3;
		}else {
			return donGia;
		}
	}
	@Override
	public String toString() {
		return "sachGiaoKhoa [maSGK=" + maSGK + ", donGia=" + donGia + ", NXB=" + NXB + ", tinhtrang=" + tinhtrang
				+ "]";
	}
	
	
	
}
