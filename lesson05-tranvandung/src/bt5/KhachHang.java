package bt5;

public class KhachHang  {
	private int MKH;
	private String name;
	private String SDT;
	private String diaChi;

	public KhachHang() {
	}

	public KhachHang(int mKH, String name, String sDT, String diaChi) {
		MKH = mKH;
		this.name = name;
		SDT = sDT;
		this.diaChi = diaChi;
	}

	public int getMKH() {
		return MKH;
	}

	public void setMKH(int mKH) {
		MKH = mKH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "KhachHang [MKH=" + MKH + ", name=" + name + ", SDT=" + SDT + ", diaChi=" + diaChi + "]";
	}

}
