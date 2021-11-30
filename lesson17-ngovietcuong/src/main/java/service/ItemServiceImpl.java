package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.ItemDto;
import persistence.ItemsDto;

public class ItemServiceImpl implements ItemService {
	
	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		return itemDao.get(orderDate);
	}
	
	@Override
	public List<String> getTopThreeItem(int year) {
		return itemDao.getTopThreeItem(year);
	}
	
	@Override
	public List<ItemsDto> getItems() {
		return itemDao.getItems();
	}
}
