package ex04;

public class GiamDoc extends People {
	public GiamDoc(String hoTen, int namSinh, float hsLuong, float hsChucVu) {
		super(hoTen, namSinh, hsLuong);
		this.hsChucVu = hsChucVu;
	}

	private float hsChucVu;

	public GiamDoc() {
	}

	public float getHsChucVu() {
		return hsChucVu;
	}

	public void setHsChucVu(float hsChucVu) {
		this.hsChucVu = hsChucVu;
	}

	@Override
	public String toString() {
		return "" + hsChucVu;
	}

	@Override
	public long luong() {
		long luong = (long) ((this.getHsLuong() + this.hsChucVu) * 3000000);
		return luong;
	}

}
