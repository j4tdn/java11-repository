package bean;

public class CarAd {
	// class' scope
	// neu gia tri cua doi tuong ko doi thi dung static
	public static String model;

	// object's scope
	// gia tri cua doi tuong se duoc cap nhat nen dung non-static
	private String color;

	public CarAd(String color) {
		this.color = color;
	}

	// create getter and setter for private
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
