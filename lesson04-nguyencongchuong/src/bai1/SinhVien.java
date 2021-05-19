package bai1;

public class SinhVien {
	private int MSV;
	private String name;
	private float LH;
	private float TH;

	public SinhVien() {
	}

	public SinhVien(int mSV, String name, float lH, float tH) {
		super();
		MSV = mSV;
		this.name = name;
		LH = lH;
		TH = tH;
	}

	public int getMSV() {
		return MSV;
	}

	public void setMSV(int mSV) {
		MSV = mSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLH() {
		return LH;
	}

	public void setLH(float lH) {
		LH = lH;
	}

	public float getTH() {
		return TH;
	}

	public void setTH(float tH) {
		TH = tH;
	}

	@Override
	public String toString() {
		return "SinhVien [MSV=" + MSV + ", name=" + name + ", LH=" + LH + ", TH=" + TH + "]";
	}

}
