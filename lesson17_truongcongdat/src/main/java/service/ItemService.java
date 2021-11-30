package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDetailGroupDto;
import persistence.ItemDto;

public interface ItemService {
	List<ItemDto> get(LocalDate orderDate);
	List<String> getTop3(String year);
	List<ItemDetailGroupDto> getItemByIg();
}
