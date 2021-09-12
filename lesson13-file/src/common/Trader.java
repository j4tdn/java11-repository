package common;

import java.io.Serializable;

public class Trader implements FileHandler, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4747920975166066630L;
	
	private  String name;
	private  transient String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

	public Trader(String line) {
		String[] items = line.split(",\\s");
		if(items.length == 2) {
			this.city = items[0];
			this.name = items[1];
		}
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
		return "Trader:" + this.name + " in " + this.city + "\n";
	}
	
	public static Trader toObject(String line) {
		String[] items = line.split(",\\s");
		if(items.length != 2) {
			return null;
		}
		return new Trader(items[0], items[1]);
	}
}
