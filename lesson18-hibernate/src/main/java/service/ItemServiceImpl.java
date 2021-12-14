package service;

import java.util.List;

import dao.HibernateItemDao;
import dao.ItemDao;
import persistence.Item;

public class ItemServiceImpl implements ItemService {
	private ItemDao hibernateItemDao;
	
	public ItemServiceImpl() {
		hibernateItemDao = new HibernateItemDao();
	}

	public List<Item> getAll() {
		return hibernateItemDao.getAll();
	}
	
	
}
