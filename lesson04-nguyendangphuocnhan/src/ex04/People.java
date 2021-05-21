package ex04;

public abstract class People {
	public People(String hoTen, int namSinh, float hsLuong) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.hsLuong = hsLuong;
	}

	private String hoTen;
	private int namSinh;
	private float hsLuong;

	public People() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public float getHsLuong() {
		return hsLuong;
	}

	public void setHsLuong(float hsLuong) {
		this.hsLuong = hsLuong;
	}

	@Override
	public String toString() {
		return "People [hoTen=" + hoTen + ", namSinh=" + namSinh + ", hsLuong=" + hsLuong + "]";
	}

	abstract public long luong();
}
