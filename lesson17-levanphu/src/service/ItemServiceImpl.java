package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService{
		private ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<ItemDto> getItemsByDate(LocalDate date) {
		return itemDao.getItemsByDate(date);
	}

	@Override
	public List<String> getThreeItemBestSellingOfTheYear(int year) {
		return itemDao.getThreeItemBestSellingOfTheYear(year);
	}

	@Override
	public List<Item> statistic() {
		return itemDao.statistic();
	}


}