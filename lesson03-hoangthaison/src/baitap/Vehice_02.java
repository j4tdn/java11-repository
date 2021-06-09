package baitap;

public class Vehice_02 {
	public String tenchuxe;
	public String loaixe;
	public int dungtich;
	public double trigia;
	public double thue;
	
	public Vehice_02() {
		// TODO Auto-generated constructor stub
	}

	public Vehice_02(String tenchuxe, String loaixe, int dungtich, double trigia, double thue) {
		super();
		this.tenchuxe = tenchuxe;
		this.loaixe = loaixe;
		this.dungtich = dungtich;
		this.trigia = trigia;
		this.thue = thue;
	}

	public String getTenchuxe() {
		return tenchuxe;
	}

	public void setTenchuxe(String tenchuxe) {
		this.tenchuxe = tenchuxe;
	}

	public String getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}

	public int getDungtich() {
		return dungtich;
	}

	public void setDungtich(int dungtich) {
		this.dungtich = dungtich;
	}

	public double getTrigia() {
		return trigia;
	}

	public void setTrigia(double trigia) {
		this.trigia = trigia;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	@Override
	public String toString() {
		return "Vehice_02 [tenchuxe=" + tenchuxe + ", loaixe=" + loaixe + ", dungtich=" + dungtich + ", trigia="
				+ trigia + ", thue=" + thue + "]";
	}	
	
	

}
