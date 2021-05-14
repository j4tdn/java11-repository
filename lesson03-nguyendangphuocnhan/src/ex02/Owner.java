package ex02;

public class Owner {
	public Owner(String name) {
		super();
		this.name = name;
	}

	private String name;

	public Owner() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
