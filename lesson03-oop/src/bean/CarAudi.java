package bean;

public class CarAudi {
	// class's scope
	public static String model;
	//
	private String color;
	
	public CarAudi(String color) {
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
