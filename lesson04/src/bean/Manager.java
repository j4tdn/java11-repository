package bean;

public class Manager extends People{
	private int numberOfEmployees;
	
	public Manager(String hoTen, int namSinh, float heSoLuong, int numberOfEmployees) {
		super(hoTen, namSinh, heSoLuong);
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tinhLuong() {
		return (double)(this.getHeSoLuong())*2200000;
	}
	@Override
	public String toString() {
		return "Manager: " + this.getHoTen() + this.getNamSinh() + this.getHeSoLuong();
	}
	

	

}