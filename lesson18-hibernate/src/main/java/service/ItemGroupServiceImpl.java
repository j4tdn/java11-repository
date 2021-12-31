package service;

import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		itemGroupDao = new HibernateItemGroupDao();
	}
	@Override
	public List<ItemGroup> getAll() {
		return itemGroupDao.getAll();
	}
	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		return itemGroupDao.getItemsByItemGroupId();
	}
}
