package persistence;

import java.util.List;
import java.util.stream.Collectors;


//Bai 3
public class DetailItemPurchaseDto {
	private int idItem;
	private String itemName;
	private int  totalSell;
	
	
	public DetailItemPurchaseDto(int idItem, String itemName, int totalSell) {
		super();
		this.idItem = idItem;
		this.itemName = itemName;
		this.totalSell = totalSell;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getTotalSell() {
		return totalSell;
	}
	public void setTotalSell(int totalSell) {
		this.totalSell = totalSell;
	}
	@Override
	public String toString() {
		return "DetailItemPurchase [idItem=" + idItem + ", itemName=" + itemName + ", totalSell=" + totalSell + "]";
	}
	
	public static List<String> transferToListName(List<DetailItemPurchaseDto> items) {
		List<String> result= items.stream().map(DetailItemPurchaseDto::getItemName).collect(Collectors.toList());
		return result;
	}
}
