package ex05;

public class Sach {
	private String maSach;
	private int donGia;
	private String NXB;

	public Sach() {
	}

	public Sach(String maSach, int donGia, String nXB) {
		super();
		this.maSach = maSach;
		this.donGia = donGia;
		NXB = nXB;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	@Override
	public String toString() {
		return "SachGiaoKhoa [maSach=" + maSach + ", donGia=" + donGia + ", NXB=" + NXB + "]";
	}

}
