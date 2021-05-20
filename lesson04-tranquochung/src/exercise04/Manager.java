package exercise04;

public class Manager extends People {
	private int soLuongQL;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String hoTen, String namSinh, double heSoLuong, int soLuongQL) {
		super(hoTen, namSinh, heSoLuong);
		this.soLuongQL = soLuongQL;
	}

	public int getSoLuongQL() {
		return soLuongQL;
	}

	public void setSoLuongQL(int soLuongQL) {
		this.soLuongQL = soLuongQL;
	}

	@Override
	public String toString() {
		return "People [hoTen=" + getHoTen() + ", namSinh=" + getNamSinh() + ", heSoLuong=" + getHeSoLuong()
				+ "] , Manager [soLuongQL=" + soLuongQL + "]";
	}

	public double salary() {
		return getHeSoLuong() * 2200;
	}
}
