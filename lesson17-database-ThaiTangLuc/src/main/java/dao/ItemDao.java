package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import persistence.Item;
import persistence.ItemDetail;
import persistence.ItemDto;

public interface ItemDao {
	List<ItemDto> getTime(LocalDate time);
	
	List<Item> getTopQuantity(String year);
	
	List<ItemDetail> get();
}
