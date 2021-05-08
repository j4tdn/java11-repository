package bean;

public class CarAd {
	// class 's scope
	public static String model;
	
	// object's scope
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
		return model + ", " + color;
	}
	
	
}
