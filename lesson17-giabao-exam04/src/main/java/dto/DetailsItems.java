package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailsItems {
	public static final String ITEMGroup_ID = "idItemGroup";
	public static final String ITEMgroup_NAME = "nameItemGroup";
	public static final String ITEM_ID = "idItem";
	public static final String ITEM_NAME = "nameItem";
	public static final String SALE_PRICE = "saleprice";
	public static final String SALE_PURCHASE = "purchaseprice";
	public static final String AMOUNT= "amount";
	
	
	
	
	private int idItemGroup;
	private String nameItemGroup;
	private int idItem;
	private String nameItem;
	private int saleprice;
	private int purchaseprice;
	private int amount;
	
	public DetailsItems() {
	}

	public DetailsItems(int idItemGroup, String nameItemGroup, int idItem, String nameItem, int saleprice,
			int purchaseprice, int amount) {
		super();
		this.idItemGroup = idItemGroup;
		this.nameItemGroup = nameItemGroup;
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.saleprice = saleprice;
		this.purchaseprice = purchaseprice;
		this.amount = amount;
	}

	public int getIdItemGroup() {
		return idItemGroup;
	}

	public void setIdItemGroup(int idItemGroup) {
		this.idItemGroup = idItemGroup;
	}

	public String getNameItemGroup() {
		return nameItemGroup;
	}

	public void setNameItemGroup(String nameItemGroup) {
		this.nameItemGroup = nameItemGroup;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(int purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DetailsItems [idItemGroup=" + idItemGroup + ", nameItemGroup=" + nameItemGroup + ", idItem=" + idItem
				+ ", nameItem=" + nameItem + ", saleprice=" + saleprice + ", purchaseprice=" + purchaseprice
				+ ", amount=" + amount + "]";
	}
	
	public static DetailsItems addResultTransfomer(ResultSet rs) throws SQLException {
		return new DetailsItems(rs.getInt(DetailsItems.ITEMGroup_ID), 
								rs.getString(DetailsItems.ITEMgroup_NAME),
								rs.getInt(DetailsItems.ITEM_ID),
								rs.getString(DetailsItems.ITEM_NAME),
								rs.getInt(DetailsItems.SALE_PRICE),
								rs.getInt(DetailsItems.SALE_PURCHASE),
								rs.getInt(DetailsItems.AMOUNT));
	}
	
	
}
