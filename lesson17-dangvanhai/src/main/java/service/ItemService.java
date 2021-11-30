package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDetailDto;
import persistence.ItemDto;

public interface ItemService {
	List<ItemDto> get(LocalDate orderDate);
	List<String> getTopHotItemsName(int year);
	List<ItemDetailDto> getAll();
}
