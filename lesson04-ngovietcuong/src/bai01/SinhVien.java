package bai01;

public class SinhVien {
	private int maSV;
	private String hoTen;
	private float diemLT;
	private float diemTH;

	public SinhVien() {
	}

	public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
		return maSV + "\t" + hoTen + "\t" + diemLT + "\t" + diemTH + "\t" + diemTB();
	}

	public double diemTB() {
		return (diemLT + diemTH) / 2;
	}
}
