package student;

import java.util.Scanner;

public class Student {
		private int MaSV;
		private String TenSV;
		private float DiemLT,DiemTH;
		
		
		public Student() {
		}
		
		public int getMaSV() {
			return MaSV;
		}

		public String getTenSV() {
			return TenSV;
		}

		public float getDiemLT() {
			return DiemLT;
		}

		public float getDiemTH() {
			return DiemTH;
		}

		public void setMaSV(int maSV) {
			MaSV = maSV;
		}

		public void setTenSV(String tenSV) {
			TenSV = tenSV;
		}

		public void setDiemLT(float diemLT) {
			DiemLT = diemLT;
		}

		public void setDiemTH(float diemTH) {
			DiemTH = diemTH;
		}
		
	    public Student(int maSV, String tenSV, float diemLT, float diemTH) {
			super();
			MaSV = maSV;
			TenSV = tenSV;
			DiemLT = diemLT;
			DiemTH = diemTH;
		}

		@Override
		public String toString() {
			return "Student [MaSV=" + MaSV + ", TenSV=" + TenSV + ", DiemLT=" + DiemLT + ", DiemTH=" + DiemTH + ",DiemTB = "+ TinhDiemTB(DiemLT, DiemTH) + "]";
		}
	    public void Nhap() {
	    	Scanner sv = new Scanner(System.in);
	    	
	    	System.out.println("Ten: ");
	    	setTenSV(sv.nextLine());
	    	System.out.println("MaSv: ");
	    	setMaSV(sv.nextInt());
	    	System.out.println("DiemTH: ");
	    	setDiemTH(sv.nextFloat());
	    	System.out.println("DiemLT: ");
	    	setDiemLT(sv.nextFloat());
	    }

		public float TinhDiemTB(float diemLT,float diemTH) {
			float DiemTB = 0.0f;
	    	DiemTB = (this.getDiemLT() + this.getDiemTH())/2;
	    	return DiemTB;
	    }


}
