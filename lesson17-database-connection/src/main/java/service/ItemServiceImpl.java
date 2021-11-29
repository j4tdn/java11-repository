package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService {
	private ItemDaoImpl itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<Item> getItemByItemGroupName(String igname) {
		return itemDao.getItemByItemGroupName(igname);
	}

	@Override
	public List<Item> get(LocalDate orderDate) {

		return itemDao.get(orderDate);
	}

}
