package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemDto;

public interface ItemService {
	List<ItemDto> getItemsByDate(LocalDate orderDate);
	
	List<String> getThreeItemBestSellingOfTheYear(int year);
	
	List<Item> statistic();
}
