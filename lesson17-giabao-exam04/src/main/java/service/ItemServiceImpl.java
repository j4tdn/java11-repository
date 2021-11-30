package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dto.RemainingItem;
import dto.ItemWithDate;

public class ItemServiceImpl implements ItemService{
	
	private static ItemDao itemDao;
	
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	public List<ItemWithDate> getItemWithDate(LocalDate orderDate) {
		return itemDao.getItemWithDate(orderDate);
	}

	public List<RemainingItem> getRemainingItems() {
		return itemDao.getRemainingItems();
	}

	public List<String> getTop3SaleItems(int year) {
		return itemDao.getTop3SaleItems(year);
	}

}
