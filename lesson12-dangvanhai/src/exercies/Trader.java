package exercies;

public class Trader {
	private String name;
	private String city;

	public Trader() {
	}

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
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
	public boolean equals(Object obj) {
		if (!(obj instanceof Trader)) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		Trader that = (Trader) obj;
		
		if(this.getName().equals(that.getName())
				&& this.getCity().equals(that.getCity())) {
			return true;
		}
		
		return false;
	}
}
