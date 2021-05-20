package exercise04;

public class Director extends People {
	private double hesoChuc;

	public Director() {

	}

	public Director(String hoTen, String namSinh, double heSoLuong, double hesoChuc) {
		super(hoTen, namSinh, heSoLuong);
		this.hesoChuc = hesoChuc;
	}

	public double getHesoChuc() {
		return hesoChuc;
	}

	public void setHesoChuc(double hesoChuc) {
		this.hesoChuc = hesoChuc;
	}

	@Override
	public String toString() {
		return "People [hoTen=" + getHoTen() + ", namSinh=" + getNamSinh() + ", heSoLuong=" + getHeSoLuong()
				+ "] , Director [hesoChuc=" + hesoChuc + "]";
	}

	public double salary() {
		return (getHeSoLuong() + hesoChuc) * 3000;
	}
}
