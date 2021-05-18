package student;

	import java.util.Scanner;

	public class Student {
		private int MaSV;
		private String TenSV ;
		private float DiemLT;
		private float DiemTH;
		
		public Student() {
			this.MaSV = 0;
			this.TenSV = "";
			this.DiemLT = 0.0f;
			this.DiemTH = 0.0f;
		}
		public Student(int maSV, String tenSV, float diemLT, float diemTH) {
			super();
			MaSV = maSV;
			TenSV = tenSV;
			DiemLT = diemLT;
			DiemTH = diemTH;
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
	

		@Override
		public String toString() {
			return "Student [MaSV=" + MaSV + ", TenSV=" + TenSV + ", DiemLT=" + DiemLT + ", DiemTH=" + DiemTH + ",DiemTB=" + DiemTB() + "]";
		}
		
		
		public void input() {
			Scanner sv = new Scanner(System.in);
			
			System.out.println("TenSV: ");
			setTenSV(sv.nextLine());
			
			System.out.println("MaSV: ");
			setMaSV(sv.nextInt());
			
			System.out.println("DiemLT: ");
			setDiemLT(sv.nextFloat());
			
			System.out.println("DiemTH: ");
			setDiemTH(sv.nextFloat());
		
		}
		
		public float DiemTB() {
			float DiemTB = 0.0f;
			
			DiemTB = (this.getDiemLT() + this.getDiemTH()) / 2;
			
			return DiemTB;
		}
	}

