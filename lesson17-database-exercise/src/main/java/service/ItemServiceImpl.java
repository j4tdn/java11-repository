package service;

import java.util.List;
import java.util.Objects;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService {
	private static ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}
	@Override
	public List<Item> get(String name) {
		Objects.requireNonNull(name, "name cannot be null");
		return itemDao.get(name);
	}
}
