package bai05;

public class SGK extends Sach{
   private String tinhTrangSach;
   
   public SGK() {
}

public SGK(String maSach, double donGia, String nhaXB, String tinhTrangSach) {
	super(maSach, donGia, nhaXB);
	this.tinhTrangSach = tinhTrangSach;
}

public String getTinhTrangSach() {
	return tinhTrangSach;
}

public void setTinhTrangSach(String tinhTrangSach) {
	this.tinhTrangSach = tinhTrangSach;
}

@Override
public String toString() {
	return super.toString() + " " + tinhTrangSach;
}
   
   
}
