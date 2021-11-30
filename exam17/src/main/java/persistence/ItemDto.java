package persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ItemDto {
	private Integer id;
	private String name;
	private Date date;

	public ItemDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemDto(Integer id, String name, Date date) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
