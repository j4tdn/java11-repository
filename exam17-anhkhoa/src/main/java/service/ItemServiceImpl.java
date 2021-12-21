package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import dao.ItemDaoImpl;
import persistence.Item;
import persistence.ItemAndItemGroupDto;
import persistence.ItemDto;

public class ItemServiceImpl implements ItemService {
	private ItemDaoImpl itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	

	@Override
	public List<ItemDto> get(LocalDate orderDate) {
		Objects.requireNonNull(orderDate, "ngay thang khong duoc null");
		return itemDao.get(orderDate);
	}

	@Override
	public List<String> getTopOfYear(int year) {

		return itemDao.getTopOfYear(year);
	}

	@Override
	public List<ItemAndItemGroupDto> getAllItemAndItemGroup() {

		return itemDao.getAllItemAndItemGroup();
	}

}
