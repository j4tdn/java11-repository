package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemDetailDto;
import persistence.ItemDto;

public interface ItemDao {
	List<ItemDto> get(LocalDate orderDate);
	List<Item> getTopHotItems(int year);
	List<ItemDetailDto> getAll();
}
