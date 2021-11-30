package persistence;

import java.sql.Time;

public class ItemGroup {

	private Integer id;
	private String name;
	private Time time;
	
	
	
	public ItemGroup() {
		
	}

	public ItemGroup(Integer id, String name, Time time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
	
	
	
}
