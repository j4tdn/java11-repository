package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RemainingItem {
	public static final String ITEM_ID = "itemGroupId";
	public static final String ITEM_NAME = "igName";
	public static final String ITEM_AMOUNT = "amount";
	
	private Integer id;
	private String name;
	private Integer amount;
	
	
	public RemainingItem() {
	}
	
	public RemainingItem(Integer id, String name, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "RemainingItem [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
	
	public static RemainingItem addResultTransfomer(ResultSet rs) throws SQLException {
		return new RemainingItem(rs.getInt(RemainingItem.ITEM_ID), 
								rs.getString(RemainingItem.ITEM_NAME),
								rs.getInt(RemainingItem.ITEM_AMOUNT));
	}

}