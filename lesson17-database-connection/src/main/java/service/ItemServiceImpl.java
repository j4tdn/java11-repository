package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService{
	
	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<Item> get(String igName) {
		return itemDao.get(igName);
	}

	@Override
	public List<Item> get(LocalDate orderDate) {
		return itemDao.get(orderDate);
	}

}
