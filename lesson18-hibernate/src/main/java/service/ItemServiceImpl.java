package service;

import java.util.List;

import dao.HibernateItemDao;
import dao.ItemDao;
import persistence.Item;

public class ItemServiceImpl implements ItemService{
	private static ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new HibernateItemDao();
	}

	public List<Item> getAll() {
		return itemDao.getAll();
	}

	public Item getItem(int itemId) {
		return itemDao.getItem(itemId);
	}
	
}
