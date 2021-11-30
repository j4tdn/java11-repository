package dao;

import java.time.LocalDate;
import java.util.List;

import dto.RemainingItem;
import dto.ItemWithDate;
import persistence.Item;

public interface ItemDao {
	List<ItemWithDate> getItemWithDate(LocalDate orderDate);
	List<RemainingItem> getRemainingItems();
	List<String> getTop3SaleItems(int year);
}