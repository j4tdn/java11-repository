package bai_05;

public class sachThamKhao {
	private String maSTK;
	private double donGia;
	private String NXB;
	private double thue;
	public sachThamKhao() {
		
	}
	public sachThamKhao(String maSTK, double donGia, String nXB, String tinhtrang) {
		super();
		this.maSTK = maSTK;
		this.donGia = donGia;
		NXB = nXB;
		this.thue = thue;
	}
	public String getMaSTK() {
		return maSTK;
	}
	public void setMaSTK(String maSTK) {
		this.maSTK = maSTK;
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
	public double getThue() {
		return thue;
	}
	public void setTinhtrang(double thue) {
		this.thue = thue;
	}
	
	public double TinhthanhtienSTK() {
		return donGia*(1+thue/100);
	}
	@Override
	public String toString() {
		return "sachThamKhao [maSTK=" + maSTK + ", donGia=" + donGia + ", NXB=" + NXB + ", thue=" + thue + "]";
	}
	
	
}
