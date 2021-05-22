package bt5;

public class SachThamKhao extends MotherBook{
	private String maSTK;
	private double thue;

	public SachThamKhao() {
		
	}

	public SachThamKhao(String maSTK, double thue) {
		super();
		this.maSTK = maSTK;
		this.thue = thue;
	}

	public String getMaSTK() {
		return maSTK;
	}

	public void setMaSTK(String maSTK) {
		this.maSTK = maSTK;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	@Override
	public String toString() {
		return "SachThamKhao [maSTK=" + maSTK + ", thue=" + thue + "]";
	}

	@Override
	void stc() {
		System.out.println(this.getNXB()== "Nhi Dong");
	}

}
