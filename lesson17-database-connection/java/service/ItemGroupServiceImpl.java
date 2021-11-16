package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.ItemGroupDaopl;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {

	private ItemGroupDao itemGroupDao;

	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaopl();
	}

	@Override
	public List<ItemGroup> getAll() {
		// TODO Auto-generated method stub
		return itemGroupDao.getAll();
	}

	@Override
	public ItemGroup get(int id) {
		return itemGroupDao.get(id);
	}

	@Override
	public boolean save(ItemGroup itemGroup) {
	Objects.requireNonNull(itemGroup,"item group cannot be null");
		return itemGroupDao.save(itemGroup);
	}

}
