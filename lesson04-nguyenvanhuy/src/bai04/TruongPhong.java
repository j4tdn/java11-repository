package bai04;

public class TruongPhong extends People {
	private int slnvql;

	public TruongPhong() {
		// TODO Auto-generated constructor stub
	}

	public TruongPhong(String hoten, int namsinh, int hsluong, int slnvql) {
		super(hoten, namsinh, hsluong);
		this.slnvql = slnvql;
	}

	public int getSlnvql() {
		return slnvql;
	}

	public void setSlnvql(int slnvql) {
		this.slnvql = slnvql;
	}

	@Override
	public String toString() {
		return "TruongPhong [slnvql=" + slnvql + ", getSlnvql()=" + getSlnvql() + "]";
	}

	@Override
	double getLuong() {
		return getHsluong() * 2200000;
	}

}
