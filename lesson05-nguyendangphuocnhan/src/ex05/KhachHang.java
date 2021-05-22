package ex05;

public class KhachHang {
	public KhachHang(int maKH, String hoten, int sdt, String diaChi) {
		super();
		this.maKH = maKH;
		this.hoten = hoten;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}

	private int maKH;
	private String hoten;
	private int sdt;
	private String diaChi;

	public KhachHang() {
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoten=" + hoten + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}

}
