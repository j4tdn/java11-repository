package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.ItemDto;
import persistence.ItemGroupAndItemDto;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public List<ItemDto> getItemDto(LocalDate orderDate) {
		return itemDao.getItemDto(orderDate);
	}

	@Override
	public List<String> getItem(int year) {
		return itemDao.getItem(year);
	}

	@Override
	public List<ItemGroupAndItemDto> getAllItembyAllItemGroup() {
		return itemDao.getAllItembyAllItemGroup();
	}
}
