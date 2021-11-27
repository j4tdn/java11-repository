package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService {
	
	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}
	
	@Override
	public List<Item> get(String igName) {
		Objects.requireNonNull(igName, "igName cannot be null");
		return itemDao.get(igName);
	}

	@Override
	public List<Item> get(LocalDate orderDate) {
		Objects.requireNonNull(orderDate, "orderDate cannot be null");
		return itemDao.get(orderDate);
	}

}
