package persistence;

public class DepartmentDto {

	public static final String DEPT_ID = "id";
	public static final String DEPT_NAME = "name";
	public static final String DEPT_TOTAL = "total";

	private String id;
	private String name;
	private Double total;

	public DepartmentDto() {
	}

	public DepartmentDto(String id, String name, Double total) {
		this.id = id;
		this.name = name;
		this.total = total;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", name=" + name + ", total=" + total + "]";
	}
}