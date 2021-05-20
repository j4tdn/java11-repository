package baitap01;

public class SinhVien {
	public int MSSV;
	public String NameSV;
	public float DiemLT;
	public float DiemTH;
	public SinhVien() {
		
	}
	public SinhVien(int mSSV, String nameSV, float diemLT, float diemTH) {
		super();
		MSSV = mSSV;
		NameSV = nameSV;
		DiemLT = diemLT;
		DiemTH = diemTH;
	}

	
	public int getMSSV() {
		return MSSV;
	}
	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}
	public String getNameSV() {
		return NameSV;
	}
	public void setNameSV(String nameSV) {
		NameSV = nameSV;
	}
	public float getDiemLT() {
		return DiemLT;
	}
	public void setDiemLT(float diemLT) {
		DiemLT = diemLT;
	}
	public float getDiemTH() {
		return DiemTH;
	}
	public void setDiemTH(float diemTH) {
		DiemTH = diemTH;
	}
	@Override
	public String toString() {
		return "SinhVien [MSSV=" + MSSV + ", NameSV=" + NameSV + ", DiemLT=" + DiemLT + ", DiemTH=" + DiemTH + "]";
	}
	

}
