package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;

public interface ItemDao {
	
	List<ItemDto> get(LocalDate orderDate); 
	
}
