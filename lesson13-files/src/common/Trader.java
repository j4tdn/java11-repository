package common;

import java.io.Serializable;

/***
 * 
 * Class implements Serializable
 * Default: All attributes will be serialized to byte stream before store in memory, file
 * Mark 'transient' >> don't write transient attribute's value to memory, file
 *
 */
public class Trader implements FileHandler, Serializable  {
	private transient String name;
	private String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}
	
	public Trader(String line) {
		String[] items = line.split(",\\s");
		 if (items.length == 2) {
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

	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
	
	@Override
	public String toLine() {
		return getCity() + ", " + getName();
	}
	
	public static Trader toObject(String line) {
		String[] items = line.split(",\\s");
		 if (items.length != 2) {
			 return null;
		 }	
		 return new Trader(items[1], items[0]);
	}

	@Override
	public Trader toObject() {
		return null;
	}
}