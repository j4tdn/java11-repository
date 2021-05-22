package bean;

public class Director extends People{
	private float heSoChucVu;
	
	public Director(String hoTen, int namSinh, float heSoLuong, float heSoChucVu) {
		super(hoTen, namSinh, heSoLuong);
		this.heSoChucVu = heSoChucVu;
	}

	@Override
	public double tinhLuong() {
		return (this.getHeSoLuong() + this.heSoChucVu)*3000000;
	}
	@Override
	public String toString() {
		return "Director: " + this.getHoTen() + this.getNamSinh() + this.getHeSoLuong();
	}
	
	

}