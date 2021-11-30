package service;

import java.util.List;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemGroupDto;
import persistence.ItemsDto;

public class ItemGroupServiceImpl implements ItemGroupService{
	private ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}
	
	@Override
	public List<ItemGroupDto> getAmountItemGroup() {
		return itemGroupDao.getAmountItemGroup();
	}

	@Override
	public List<ItemsDto> getAllItemById() {
		return itemGroupDao.getAllItemById();
	}
	
}
