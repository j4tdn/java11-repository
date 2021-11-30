package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupAndItemDto;

public interface ItemService {
	List<ItemDto> getItemDto(LocalDate orderDate);

	List<String> getItem(int year);

	List<ItemGroupAndItemDto> getAllItembyAllItemGroup();

}
