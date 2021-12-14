package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

public interface ItemService {
	List<Item> get(String name);
	
	List<Item> get(LocalDate orderDate);

	List<Item> getAll();
	
}