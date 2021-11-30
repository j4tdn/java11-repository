package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService {
	
	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<ItemDto> getItemSoldByDay(LocalDate orderDay) {
		return itemDao.getItemSoldByDay(orderDay);
	}

	@Override
	public List<String> getItemBestSold(int year) {
		return itemDao.getItemBestSold(year);
	}

}
