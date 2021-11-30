package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoIpml;
import persistence.ItemDto;

public class ItemServiceIpml implements ItemService {
	private static ItemDao itemDao;
	
	public ItemServiceIpml() {
		itemDao = new ItemDaoIpml();
	}
	
	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		return itemDao.get(orderDate);
	}
}
