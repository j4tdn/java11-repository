package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;

public interface ItemService {
	List<ItemDto> get(LocalDate orderDate); 

}
