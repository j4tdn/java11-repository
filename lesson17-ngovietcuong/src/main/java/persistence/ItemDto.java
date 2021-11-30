package persistence;

public class ItemDto {
	private Integer id;
	private String name;
	private String date;
	
	public ItemDto() {

	}

	public ItemDto(Integer id, String name, String date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
}
