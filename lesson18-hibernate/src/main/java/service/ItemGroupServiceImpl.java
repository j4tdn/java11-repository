package service;

import java.util.List;

import dao.ItemGroupDao;
import dao.HibernateItemGroupDao;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService{
	
	private ItemGroupDao itemGroupDao;

	public ItemGroupServiceImpl() {
		itemGroupDao = new HibernateItemGroupDao();
	}


	public List<ItemGroup> getAll() {
		// TODO Auto-generated method stub
		return itemGroupDao.getAll();
	}

}
