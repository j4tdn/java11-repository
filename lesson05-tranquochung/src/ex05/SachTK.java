package ex05;

public class SachTK extends Sach {
	private int thue;

	public SachTK() {
		// TODO Auto-generated constructor stub
	}

	public SachTK(String maSach, double donGia, String nhaXB, int thue) {
		super(maSach, donGia, nhaXB);
		this.thue = thue;
	}

	public int getThue() {
		return thue;
	}

	public void setThue(int thue) {
		this.thue = thue;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + getMaSach() + ", donGia=" + getDonGia() + ", nhaXB=" + getNhaXB() + "]"
				+ "SachTK [thue=" + thue + "]";
	}

	@Override
	double tinhtien() {
		return this.getDonGia()*(1 + thue);
	}
	
	
}
