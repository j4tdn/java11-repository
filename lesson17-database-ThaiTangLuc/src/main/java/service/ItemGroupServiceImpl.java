package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService{
	private ItemGroupDao igDao;
	public ItemGroupServiceImpl() {
		igDao = new ItemGroupDaoImpl();
	}
	
	@Override
	public List<ItemGroupDto> get() {
		return igDao.get();
	}
	
	
}
