package bean;

public class CarAd {
	// class's cope
	public static String model;

	// object's class
	private String color;

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
		return model + "," + color;
	}
}
