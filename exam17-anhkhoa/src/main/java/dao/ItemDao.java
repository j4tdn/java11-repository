package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;
import persistence.ItemAndItemGroupDto;
import persistence.ItemDto;

public interface ItemDao {
	List<ItemDto> get(LocalDate orderDate);

	List<String> getTopOfYear(int year);

	List<ItemAndItemGroupDto> getAllItemAndItemGroup();
}
