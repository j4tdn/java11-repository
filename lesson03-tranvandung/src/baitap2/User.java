package baitap2;

public class User {
	private String id;
	private String name;
	private String cmnd;

	public User() {

	}

	public User(String id, String name, String cmnd) {

		this.id = id;
		this.name = name;
		this.cmnd = cmnd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", cmnd=" + cmnd + "]";
	}

}
