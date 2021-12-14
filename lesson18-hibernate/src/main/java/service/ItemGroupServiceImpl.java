package service;

import java.util.List;

import dao.ItemGroupDao;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {

	private ItemGroupDao itemGroupDao;
	
	@Override
	public List<ItemGroup> getAll() {
		return itemGroupDao.getAll();
	}
}
