package service;

import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.Item;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {
	private ItemGroupDao dao;
	
	public ItemGroupServiceImpl() {
		dao = new HibernateItemGroupDao();
	}

	public List<ItemGroup> getAll() {
		return dao.getAll();
	}
	
}
