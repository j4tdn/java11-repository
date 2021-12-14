package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService{
	private ItemGroupDao igDao;
	public ItemGroupServiceImpl() {
		igDao = new ItemGroupDaoImpl();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		return igDao.getAll();
	}
	
	@Override
	public List<ItemGroup> get(String name) {
		return igDao.get(name);
	}
	
	@Override
	public boolean save(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "itemGroup cannot be null");
		return igDao.save(itemGroup);
	}
}
