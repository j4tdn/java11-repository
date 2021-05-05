package bean;

public class CarAudi {
	public static String model;
	private String color;
	
	
	public CarAudi(String color) {
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
		return model + ", " + color;
	}

}
