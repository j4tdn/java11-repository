package bean;

public class CarAd {
	//class's scope
	public static String model;
	
	
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
		// TODO Auto-generated method stub
		return  model + ", " +color;
	}

}
