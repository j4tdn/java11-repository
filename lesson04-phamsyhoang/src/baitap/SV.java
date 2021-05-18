package baitap;

public class SV {
	private int mssv;
	private String hoten;
	private float diemLT;
	private float diemTH;

	public SV() {
	}

	public SV(int mssv, String hoten, float diemLT, float diemTH) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	@Override
	public String toString() {
		return "SV [mssv=" + mssv + ", hoten=" + hoten + ", diemLT=" + diemLT + ", diemTH=" + diemTH + "]";
	}
	
	public float diemTB() {
		float diemTB =(this.diemLT + this.diemTH)/2;
		return diemTB;
	}
}
