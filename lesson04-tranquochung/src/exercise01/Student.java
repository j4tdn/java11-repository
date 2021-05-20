package exercise01;

public class Student {
	private int maSV;
	private String ten;
	private float diemLT;
	private float diemTH;

	public Student() {
	}

	public Student(int maSV, String ten, float diemLT, float diemTH) {
		this.maSV = maSV;
		this.ten = ten;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
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
		return "Student [maSV=" + maSV + ", ten=" + ten + ", diemLT=" + diemLT + ", diemTH=" + diemTH + "]";
	}

	public float diemTB() {
		return (diemLT + diemTH) / 2;
	}
}
