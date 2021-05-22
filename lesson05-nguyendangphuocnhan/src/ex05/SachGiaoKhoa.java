package ex05;

public class SachGiaoKhoa extends Sach {
	public SachGiaoKhoa(String maSach, int donGia, String NXB, String tinhTrang) {
		super(maSach, donGia, NXB);
		this.tinhTrang = tinhTrang;
	}
	
	private String tinhTrang;

	public SachGiaoKhoa() {
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "SachGiaoKhoa [tinhTrang=" + tinhTrang + ", getTinhTrang()=" + getTinhTrang() + "]";
	}

}
