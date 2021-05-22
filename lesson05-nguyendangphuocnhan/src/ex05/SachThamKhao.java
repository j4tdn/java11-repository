package ex05;

public class SachThamKhao extends Sach {
	public SachThamKhao(String maSach, int donGia, String NXB, float thue) {
		super(maSach, donGia, NXB);
		this.thue = thue;
	}
	
	private float thue;
	
	public SachThamKhao() {
	}
	
	public float getThue() {
		return thue;
	}
	public void setThue(float thue) {
		this.thue = thue;
	}
	@Override
	public String toString() {
		return "SachThamKhao [thue=" + thue + "]";
	}
		
}
