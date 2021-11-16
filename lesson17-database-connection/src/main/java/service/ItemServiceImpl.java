package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemGroup;

public class ItemServiceImpl implements ItemService{
	private ItemGroupDao itemGroupDao;
	
	public ItemServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}

	@Override
	public List<ItemGroup> itemGroups() {
		return itemGroupDao.getAll();
	}

	@Override
	public boolean save(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup);
		return itemGroupDao.save(itemGroup);
	}

}
