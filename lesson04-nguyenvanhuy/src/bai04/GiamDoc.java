package bai04;

public class GiamDoc extends People {
	private int hscv;

	public GiamDoc() {
		
	}

	public GiamDoc(String hoten, int namsinh, int hsluong, int hscv) {
		super(hoten, namsinh, hsluong);
		this.hscv = hscv;
	}

	public int getHscv() {
		return hscv;
	}

	public void setHscv(int hscv) {
		this.hscv = hscv;
	}

	@Override
	public String toString() {
		return "GiamDoc [hscv=" + hscv + ", getHscv()=" + getHscv() + "]";
	}

	@Override
	double getLuong() {
		return (getHsluong() + getHscv()) * 1250000;

	}
}
