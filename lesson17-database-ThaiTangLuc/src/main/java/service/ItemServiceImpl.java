package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.Item;
import persistence.ItemDetail;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService {
	private static ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}
	

	@Override
	public List<ItemDto> getTime(LocalDate time) {
		Objects.requireNonNull(time, "time cannot be null");
		return itemDao.getTime(time);
	}

	@Override
	public List<Item> getTopQuantity(String year) {
		Objects.requireNonNull(year, "year cannot be null");
		return itemDao.getTopQuantity(year);
	}

	@Override
	public List<ItemDetail> get() {
		return itemDao.get();
	}
}
