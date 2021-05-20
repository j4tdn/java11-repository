package bai04;

public class NhanVien extends People {
	private String phongban;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String hoten, int namsinh, int hsluong, String phongban) {
		super(hoten, namsinh, hsluong);
		this.phongban = phongban;
	}

	public String getPhongban() {
		return phongban;
	}

	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}

	@Override
	public String toString() {
		return "NhanVien [phongban=" + phongban + ", getPhongban()=" + getPhongban() + "]";
	}

	@Override
	double getLuong() {
		return getHsluong() * 3000000;
	}
}
