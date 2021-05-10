package ex02;

import java.math.BigDecimal;

public class Vehicle {
	// Attributes
	private String ownerName;
	private String model;
	private int volCylinder; // Volume of cylinder
	private BigDecimal price;
	private BigDecimal regFee; // Registration fee

	// Constructors
	public Vehicle() {
	}

	public Vehicle(String ownerName, String model, int volCylinder, BigDecimal price) {
		this.ownerName = ownerName;
		this.model = model;
		this.volCylinder = volCylinder;
		this.price = price;
		this.regFee = calRegFee(volCylinder, price);
	}

	// Getters and setters
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getVolCylinder() {
		return volCylinder;
	}

	public void setVolCylinder(int volCylinder) {
		this.volCylinder = volCylinder;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
		this.regFee = calRegFee(this.volCylinder, price);
	}

	public BigDecimal getRegFee() {
		return regFee;
	}

	/*
	 * Formation is based on the table
	 */
	@Override
	public String toString() {
		return String.format("%-30s %-20s %-15s %-20s %-15s", ownerName, model, volCylinder, price.setScale(2),
				regFee.setScale(2));
	}

	// Calculation registration fee
	private static BigDecimal calRegFee(int volCylinder, BigDecimal price) {
		// less than 100cc: 1%
		if (volCylinder < 100) {
			return price.multiply(new BigDecimal(1).divide(new BigDecimal(100)));
		}

		// from 100 to 200cc: 3%
		if (volCylinder < 200) {
			return price.multiply(new BigDecimal(3).divide(new BigDecimal(100)));
		}

		// great than 200cc : 5%
		return price.multiply(new BigDecimal(5).divide(new BigDecimal(100)));
	}
}
