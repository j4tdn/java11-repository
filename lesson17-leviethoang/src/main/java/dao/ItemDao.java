package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemDto;

public interface ItemDao {
	List<ItemDto> getItemsByDate(LocalDate orderDate); // 1
	
	List<String> getThreeItemBestSellingOfTheYear(int year); // 3
	
	List<Item> statistic(); // 4
}
