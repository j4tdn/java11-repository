package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class ItemDetailDto {
	public static final String ID = "MaMH";
	public static final String ITEM_NAME = "TenMH";
	public static final String ID_ITEM_GROUP = "MaLH";
	public static final String ITEM_GROUP_NAME = "TenLH";
	public static final String PRICE = "GiaBan";
	public static final String IMPORT_PRICE = "GiaMua";
	public static final String NUMBER_OF_REMAINING = "SoLuong";
	
	
	private Integer id;
	private String name;
	private Integer idIg;
	private String igIgName;
	private Double price;
	private Double importPrice;
	private Integer numberOfRemainig;
	public ItemDetailDto(Integer id, String name, Integer idIg, String igIgName, Double price, Double importPrice,
			Integer numberOfRemainig) {
		super();
		this.id = id;
		this.name = name;
		this.idIg = idIg;
		this.igIgName = igIgName;
		this.price = price;
		this.importPrice = importPrice;
		this.numberOfRemainig = numberOfRemainig;
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
	public Integer getIdIg() {
		return idIg;
	}
	public void setIdIg(Integer idIg) {
		this.idIg = idIg;
	}
	public String getIgIgName() {
		return igIgName;
	}
	public void setIgIgName(String igIgName) {
		this.igIgName = igIgName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(Double importPrice) {
		this.importPrice = importPrice;
	}
	public Integer getNumberOfRemainig() {
		return numberOfRemainig;
	}
	public void setNumberOfRemainig(Integer numberOfRemainig) {
		this.numberOfRemainig = numberOfRemainig;
	}
	@Override
	public String toString() {
		return "ItemDetailDto [id=" + id + ", name=" + name + ", idIg=" + idIg + ", igIgName=" + igIgName + ", price="
				+ price + ", importPrice=" + importPrice + ", numberOfRemainig=" + numberOfRemainig + "]";
	}
	
	public static ItemDetailDto addResultTransfomer(ResultSet rs) throws SQLException {
		return new ItemDetailDto(
				rs.getInt(ItemDetailDto.ID), 
				rs.getString(ItemDetailDto.ITEM_NAME),
				rs.getInt(ItemDetailDto.ID_ITEM_GROUP),
				rs.getString(ItemDetailDto.ITEM_GROUP_NAME),
				rs.getDouble(ItemDetailDto.PRICE),
				rs.getDouble(ItemDetailDto.IMPORT_PRICE),
				rs.getInt(ItemDetailDto.NUMBER_OF_REMAINING)
		);
	}
}
