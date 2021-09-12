package common;

import java.io.Serializable;

public class Trader implements FileHandler, Serializable {
	private static final long serialVersionUID = 1L;
	private transient String name;
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

	public String toLine() {
		return getCity() + ", " + getName();
	}
	
	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
	
	public static Trader toObject(String line) {
		
		String[] item = line.split(",\\s");
		if (item.length != 2) {
			return null;
		}
		return new Trader(item[1], item[0]);
	}
}