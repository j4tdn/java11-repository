package bai02;

public class Owner {
	private String owner;
	
	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(String owner) {
		super();
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Owner [owner=" + owner + "]";
	}
	
}
