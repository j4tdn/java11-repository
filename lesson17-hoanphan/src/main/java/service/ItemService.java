package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemDto;

public interface ItemService {
	List<ItemDto> getItemsByDate(LocalDate orderDate);
	List<Item> getItemsBestSeller(String year);
	List<Item> getAll();
}
