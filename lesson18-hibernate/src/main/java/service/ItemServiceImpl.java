package service;

import java.util.List;

import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService {
	
	private ItemDaoImpl itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<Item> getAll() {
		return itemDao.getAll();
	}

	@Override
	public Item getItem(int itemId) {
		return itemDao.getItem(itemId);
	}

}
