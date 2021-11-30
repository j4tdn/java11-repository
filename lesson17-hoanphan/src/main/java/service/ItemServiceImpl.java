package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.ItemGroupDaoImpl;
import persistence.Item;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService{
    private ItemDao itemDao;
    
    public ItemServiceImpl() {
    	itemDao  = new ItemDaoImpl();
    }

	@Override
	public List<ItemDto> getItemsByDate(LocalDate orderDate) {
		return itemDao.getItemsByDate(orderDate);
	}
	
	@Override
	public List<Item> getItemsBestSeller(String year) {
		return itemDao.getItemsBestSeller(year);
	}
    
	@Override
	public List<Item> getAll() {
		return itemDao.getAll();
	}
}
