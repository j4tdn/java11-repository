package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

public interface ItemDao {
	List<Item> getItemByItemGroupName(String igname);

	List<Item> get(LocalDate orderDate);
}
