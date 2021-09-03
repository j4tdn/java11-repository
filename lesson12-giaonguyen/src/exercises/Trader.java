package exercises;

public class Trader {
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
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
}
