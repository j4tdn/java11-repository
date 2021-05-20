package exercise04;

public class Employee extends People {
	private String tenDonvi;

	public Employee() {
	}

	public Employee(String hoTen, String namSinh, double heSoLuong, String tenDonvi) {
		super(hoTen, namSinh, heSoLuong);
		this.tenDonvi = tenDonvi;
	}

	public String getTenDonvi() {
		return tenDonvi;
	}

	public void setTenDonvi(String tenDonvi) {
		this.tenDonvi = tenDonvi;
	}

	@Override
	public String toString() {
		return "People [hoTen=" + getHoTen() + ", namSinh=" + getNamSinh() + ", heSoLuong=" + getHeSoLuong()
				+ "] , Employee [tenDonvi=" + tenDonvi + "]";
	}

	public double salary() {
		return getHeSoLuong() * 1250;
	}
}
