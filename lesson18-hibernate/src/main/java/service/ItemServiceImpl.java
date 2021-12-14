package service;

import java.time.LocalDate;
import java.util.List;

import dao.HibernateItemDao;
import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService{
	private static ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new HibernateItemDao();
	}
	
	@Override
	public List<Item> get(String name) {
		return itemDao.get(name);
	}
	
	@Override
	public List<Item> get(LocalDate orderDate) {
		return itemDao.get(orderDate);
	}

}