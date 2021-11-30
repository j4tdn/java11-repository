package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemDaoImpl;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {

	private ItemDaoImpl itemDao;

	public ItemGroupServiceImpl() {
		itemDao = new ItemDaoImpl();
	}
	
	@Override
	public List<ItemGroupDto> getItemsByItemGroupId(LocalDate timeOrder) {
		return itemDao.getItemGroupDto(timeOrder);
	}

}