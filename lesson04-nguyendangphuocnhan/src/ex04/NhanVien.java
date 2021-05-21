package ex04;

public class NhanVien extends People {
	public NhanVien(String hoTen, int namSinh, float hsLuong, String donVi) {
		super(hoTen, namSinh, hsLuong);
		this.donVi = donVi;
	}

	private String donVi;

	public NhanVien() {
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	@Override
	public String toString() {
		return "" + donVi;
	}

	@Override
	public long luong() {
		long luong = (long) (this.getHsLuong() * 1250000);
		return luong;
	}

}
