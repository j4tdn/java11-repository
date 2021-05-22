package bean;

public class People {
	private String hoTen;
	private int namSinh;
	private float heSoLuong;
	
	public People() {
		
	}
	
	public People(String hoTen, int namSinh, float heSoLuong) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.heSoLuong = heSoLuong;
	}
	
	public double tinhLuong() {
		return 0;	
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

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	

}