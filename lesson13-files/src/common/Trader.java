package common;

import java.io.Serializable;

public class Trader implements FileHandler, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 46744678314826869L;
	private String name;
	private String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	@Override
	public String toLine() {
		return getCity() + ", " + getName();
	}

	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
	
	public static Trader toObject(String line) {
		String[] items = line.split(",\\s");
		if (items.length != 2) {
			return null;
		}
		return new Trader(items[1], items[0]);
	}
}