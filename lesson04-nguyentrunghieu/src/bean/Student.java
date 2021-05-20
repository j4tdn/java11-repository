package bean;

public class Student {
	private int id;
	private String fullName;
	private float diemLT;
	private float diemTH;

	public Student() {
		this.id = 0;
		this.fullName = "";
		this.diemLT = 0f;
		this.diemTH = 0f;
	}

	public Student(int id, String fullName, float diemLT, float diemTH) {
		this.id = id;
		this.fullName = fullName;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public float getdiemLT() {
		return diemLT;
	}

	public void setdiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getdiemTH() {
		return diemTH;
	}

	public void setdiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	@Override
	public String toString() {
		return "Student [ id = " + id + ", fullName = " + fullName + ", diemLT = " + diemLT
				+ ", diemTH = " + diemTH + ", DTB = " + this.getDTB() + " ]";
	}

	
	public float getDTB() {
		return (float) Math.round((this.diemLT + this.diemTH) / 2 * 10) / 10;
	}


}
