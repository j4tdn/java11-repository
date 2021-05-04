package bean;

public class CarAd {
	public static String model; // class's scope
	private String color; // object's scope

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
		return model + " , " + color;
	}

}
