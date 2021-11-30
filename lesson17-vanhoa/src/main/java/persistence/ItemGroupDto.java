package persistence;

public class ItemGroupDto {
	private Integer id;
	private String name;
	private Integer numberOfItemGroup;

	public ItemGroupDto() {
	}

	public ItemGroupDto(Integer id, String name, Integer numberOfItemGroup) {
		this.id = id;
		this.name = name;
		this.numberOfItemGroup = numberOfItemGroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfItemGroup() {
		return numberOfItemGroup;
	}

	public void setNumberOfItemGroup(Integer numberOfItemGroup) {
		this.numberOfItemGroup = numberOfItemGroup;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [id=" + id + ", name=" + name + ", numberOfItemGroup=" + numberOfItemGroup + "]";
	}
	

	
}
