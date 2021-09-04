package bean;

public class Trader {
	private String name;
	private String city;
	
	public Trader() {
		// TODO Auto-generated constructor stub
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

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return name + ", " + city; 
	}

	public Object compareTo(String name2) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
