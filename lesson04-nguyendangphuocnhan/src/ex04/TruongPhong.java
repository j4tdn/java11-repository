package ex04;

public class TruongPhong extends People {
	public TruongPhong(int slnvQuanLy) {
		super();
		this.slnvQuanLy = slnvQuanLy;
	}

	private int slnvQuanLy;

	public TruongPhong() {
	}

	public int getSlnvQuanLy() {
		return slnvQuanLy;
	}

	public void setSlnvQuanLy(int slnvQuanLy) {
		this.slnvQuanLy = slnvQuanLy;
	}

	@Override
	public String toString() {
		return "" + slnvQuanLy;
	}

	@Override
	public long luong() {
		long luong = (long) (this.getHsLuong() * 2200000);
		return luong;
	}

}
