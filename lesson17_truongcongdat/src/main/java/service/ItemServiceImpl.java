package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.ItemDetailGroupDto;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService{
	
	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		return itemDao.get(orderDate);
	}

	@Override
	public List<String> getTop3(String year) {
		return itemDao.getTop3(year);
	}

	@Override
	public List<ItemDetailGroupDto> getItemByIg() {
		return itemDao.getItemByIg();
	}

}
