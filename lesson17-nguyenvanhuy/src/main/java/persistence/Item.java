package persistence;

public class Item {
	private Integer id;
	private String name;
	private String color;
	
	
	public Item() {
		
	}

	public Item(Integer idMH, String name, String color) {
		this.id = idMH;
		this.name = name;
		this.color = color;
		
	}

	public Integer getIdMH() {
		return id;
	}

	public void setIdMH(Integer idMH) {
		this.id = idMH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	@Override
	public String toString() {
		return "ItemGroup [idMH=" + id + ", name=" + name + ", color=" + color + "]";
	}
	
	
}
