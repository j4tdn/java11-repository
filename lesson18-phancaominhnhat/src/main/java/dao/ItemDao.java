package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;

public interface ItemDao {
	List<ItemDto> getItemSoldByDay(LocalDate orderDay);
	List<String> getItemBestSold(int year);
}
