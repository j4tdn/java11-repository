package bai05;

public class KhachHang {
  private String maKH;
  private String hoTen;
  private String SDT;
  private String diaChi;
  
  public KhachHang() {
}

public KhachHang(String maKH, String hoTen, String sDT, String diaChi) {
	super();
	this.maKH = maKH;
	this.hoTen = hoTen;
	SDT = sDT;
	this.diaChi = diaChi;
}

public String getMaKH() {
	return maKH;
}

public void setMaKH(String maKH) {
	this.maKH = maKH;
}

public String getHoTen() {
	return hoTen;
}

public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}

public String getSDT() {
	return SDT;
}

public void setSDT(String sDT) {
	SDT = sDT;
}

public String getDiaChi() {
	return diaChi;
}

public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}

@Override
public String toString() {
	return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", SDT=" + SDT + ", diaChi=" + diaChi + "]";
}
  
  
}
