package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemDetail;
import persistence.ItemDto;

public interface ItemService {
	List<ItemDto> getTime(LocalDate time);
	
	List<Item> getTopQuantity(String year);
	
	List<ItemDetail> get();
	
}
