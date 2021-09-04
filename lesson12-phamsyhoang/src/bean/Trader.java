package bean;

public class Trader {
	private String name;
	private String city;

	public Trader() {
	}

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}

	/*public Trader(String line) {

		String[] token = line.split("-");
		if (token.length == 2) {
			this.name = token[0];
			this.city = token[1];
		}
	}

	public static Trader transfer(String line) {
		Trader trader = null;
		String[] tokens = line.split("-");
		if (tokens.length == 2) {
			trader = new Trader(tokens[0], tokens[1]);

		}
		return trader;
	}*/

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

	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
}