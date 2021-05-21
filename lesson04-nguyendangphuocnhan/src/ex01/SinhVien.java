package ex01;

public class SinhVien {
	public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	
	private int maSV;
	private String hoTen;
	private float diemLT;
	private float diemTH;
	
	public SinhVien() {

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
	
	
	public float diemTB() {
		float diemTB = (this.diemLT + this.diemTH)/2;
		return diemTB;
	}
	
	@Override
	public String toString() {
		return maSV + "\t\t" + hoTen + "\t\t" + diemLT+ "\t\t" + diemTH + "\t\t" + diemTB();
	}
}
