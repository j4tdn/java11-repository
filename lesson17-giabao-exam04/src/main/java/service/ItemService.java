package service;

import java.time.LocalDate;
import java.util.List;

import dto.ItemWithDate;
import dto.RemainingItem;

public interface ItemService {
	List<ItemWithDate> getItemWithDate(LocalDate orderDate);
	List<RemainingItem> getRemainingItems();
	List<String> getTop3SaleItems(int year);
}