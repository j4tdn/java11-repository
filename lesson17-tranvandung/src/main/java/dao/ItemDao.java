package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemDto;

public interface ItemDao {
	
	List<Item> get(String igName);
	
	List<Item> get(LocalDate orderDate);
	
	List<ItemDto> getItemDto(LocalDate orderDate);
	
	List<String> getTop3ItemsName(int year);
}