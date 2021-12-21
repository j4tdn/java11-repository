package service;

import java.util.List;

import dao.HibernateGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {
	private ItemGroupDao dao;
	
	public ItemGroupServiceImpl() {
		dao = new HibernateGroupDao();
	}

	public List<ItemGroup> getAll() {
		return dao.getAll();
	}
	
}
