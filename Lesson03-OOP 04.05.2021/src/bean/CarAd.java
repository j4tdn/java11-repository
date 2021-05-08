package bean;

public class CarAd {
	public static String model;
	private String color;
	
	public CarAd(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "[model=" + model + ", color=" + color + "]";
	}
}
