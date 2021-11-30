package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDetailGroupDto;
import persistence.ItemDto;

public interface ItemDao {
	List<ItemDto> get(LocalDate orderDate);
	List<String> getTop3(String year);
	List<ItemDetailGroupDto> getItemByIg();
}
