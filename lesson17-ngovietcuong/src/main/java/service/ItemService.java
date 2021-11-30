package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemsDto;

public interface ItemService {
	List<ItemDto> get(LocalDate orderDate);
	
	List<String> getTopThreeItem(int year);
	
	List<ItemsDto> getItems();
}
