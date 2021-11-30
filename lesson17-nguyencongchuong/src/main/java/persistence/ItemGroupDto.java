package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;


public class ItemGroupDto {
	
	private Integer igId;
	private String igName;
	private LocalTime timeOrder;
	
	public ItemGroupDto() {
	}

	public ItemGroupDto(Integer igId, String igName, LocalTime timeOrder) {
		this.igId = igId;
		this.igName = igName;
		this.timeOrder = timeOrder;
	}

	public Integer getIgId() {
		return igId;
	}

	public void setIgId(Integer igId) {
		this.igId = igId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

	public LocalTime getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(LocalTime timeOrder) {
		this.timeOrder = timeOrder;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [igId=" + igId + ", igName=" + igName + ", timeOrder=" + timeOrder + "]";
	}
	
}