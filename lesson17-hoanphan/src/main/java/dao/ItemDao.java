package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import persistence.Item;
import persistence.ItemDto;

public interface ItemDao {
	
	List<ItemDto> getItemsByDate(LocalDate orderDate);
	
	List<Item> getItemsBestSeller(String year);
	
	List<Item> getAll();
}
