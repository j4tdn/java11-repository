package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;
import persistence.ItemDetailDto;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}
	
	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		Objects.requireNonNull(orderDate, "orderDate cannot be null");
		return itemDao.get(orderDate);
	}

	@Override
	public List<String> getTopHotItemsName(int year) {
		List<String> result = new ArrayList<>();
		List<Item> hotItems = itemDao.getTopHotItems(year);
		for(Item item : hotItems) {
			result.add(item.getName());
		}
		return result;
	}

	@Override
	public List<ItemDetailDto> getAll() {
		return itemDao.getAll();
	}

}
