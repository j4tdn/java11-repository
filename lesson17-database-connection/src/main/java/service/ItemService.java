package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

public interface ItemService {
	List<Item> getItemByItemGroupName(String igname);

	List<Item> get(LocalDate orderDate);
}
