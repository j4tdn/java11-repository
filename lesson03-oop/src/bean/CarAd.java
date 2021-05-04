package bean;

public class CarAd {
	public static String model;
	public String color;
	
	public CarAd(String color) {
		this.color = color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	@Override
	public String toString() {
		return model +","+ color;
	}
}
