package common;

import java.io.Serializable;
/**
 * 
 * @author hai
 *	Class implements Serializable
 *	Default: all attributes will be serialized to byte stream before store in memory,file
 *	
 *	Mark 'transient' (non serialized) >> dont't write transient attribute's value to memory, file
 */

public class Trader implements FileHandler <Trader>, Serializable{
//	private static final long serialVersionUID = 46744678314826869L;
	
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
	
	@Override
	public String toLine() {
		return this.city + ", " + this.getName();
	}
	
	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}

	public static Trader toObject(String line) {
		String[] items = line.split(",\\s");
		if(items.length == 2) {
			return new Trader(items[0], items[0]);
		}
		return null;
	}
	
}
