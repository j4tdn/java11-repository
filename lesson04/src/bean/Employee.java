package bean;

public class Employee extends People{

	private String tenDonVi;
	
	public Employee(String hoTen, int namSinh, float heSoLuong, String tenDonVi) {
		super(hoTen, namSinh, heSoLuong);
		this.tenDonVi = tenDonVi;
	}

	@Override
	public double tinhLuong() {
		return (double)(this.getHeSoLuong())*1250000;
	}
	@Override
	public String toString() {
		return "Employee: " + this.getHoTen() + this.getNamSinh() + this.getHeSoLuong();
	}
	

}