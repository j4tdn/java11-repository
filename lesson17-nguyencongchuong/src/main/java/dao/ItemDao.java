package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemGroupDto;

public interface ItemDao {
	List<Item> get(String igName);
	List<Item> get(LocalDate orderDate);
	
	List<ItemGroupDto> getItemGroupDto(LocalDate orderDate);
}