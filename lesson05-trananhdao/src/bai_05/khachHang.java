package bai_05;

public class khachHang {
	private String makh;
	private String hoTen;
	private String std;
	private String diachi;

	public khachHang() {
		
	}

	public khachHang(String makh, String hoTen, String std, String diachi) {
		
		this.makh = makh;
		this.hoTen = hoTen;
		this.std = std;
		this.diachi = diachi;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "khachHang [makh=" + makh + ", hoTen=" + hoTen + ", std=" + std + ", diachi=" + diachi + "]";
	}
	
}
