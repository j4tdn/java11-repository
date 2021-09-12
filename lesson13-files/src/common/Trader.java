package common;

import java.io.Serializable;

/**
 * Class implements Serializable
 * Default: all attributes will be serialized to byte stream before strore is memory, file
 * 
 * Mark 'transient' (non serialized) >> (don't write transient attribute to memory, file)
 * @author professor
 *
 */

public class Trader implements FileHandler, Serializable{
	private static final long serialVersionUID = 1L;
	
	private transient String name;
	private  String city;
	
	public Trader() {
		
	}
	
	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}
	
	public Trader(String lines) {
		String[] items = lines.split(",\\s");
		if (items.length == 2)
		{
			city = items[0];
			name = items[1];
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
		if (items.length != 2)
		{
			return null;
		}
		return new Trader(items[0], items[1]);
	}
}