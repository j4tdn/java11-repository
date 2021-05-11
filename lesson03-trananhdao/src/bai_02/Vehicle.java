package bai_02;

public class Vehicle {
	private String chuxe;
	private String loaixe;
	private int dungtich;
	private long trigia;
	public Vehicle() {
		
	}
	public Vehicle(String chuxe, String loaixe, int dungtich, long trigia) {
		
		this.chuxe = chuxe;
		this.loaixe = loaixe;
		this.dungtich = dungtich;
		this.trigia = trigia;
	}
	public String getChuxe() {
		return chuxe;
	}
	public void setChuxe(String chuxe) {
		this.chuxe = chuxe;
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
	public long getTrigia() {
		return trigia;
	}
	public void setTrigia(long trigia) {
		this.trigia = trigia;
	}
	@Override
	public String toString() {
		return "Vehicle [chuxe=" + chuxe + ", loaixe=" + loaixe + ", dungtich=" + dungtich + ", trigia=" + trigia + "]";
	}
	
	public double ThuePhaiNop() {
		if(dungtich<100) {
			return trigia*0.01;
		}
		if(dungtich <= 200) {
			return trigia*0.03;
		} else {
			return trigia*0.05;
		}
	}
	
	
	

}
