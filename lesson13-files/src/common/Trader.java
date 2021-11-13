package common;

import java.io.Serializable;

public class Trader implements FileHandler,Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2407936162595815709L;
	private String name;
	 private String city;
	 
	 public Trader() {
		// TODO Auto-generated constructor stub
	}

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
	public Trader(String line) {
		String[] items = line.split("\\s");
		if(items.length==2) {
			this.city= items[0];
			this.name =items[1];
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
	@Override
	public String toLine() {
		return getCity()+ ", " + getName();
	}
	
	public static Trader toObject(String line) {
		String[] items = line.split("\\s");
		if(items.length!=2) {
			return null;
		}
		return new Trader(items[0],items[1]);
	}
	

	
}