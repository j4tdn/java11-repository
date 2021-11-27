package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		return itemGroupDao.getALL();
	}

	@Override
	public ItemGroup get(int id) {
		return itemGroupDao.get(id);
	}

	@Override
	public List<ItemGroup> get(String name) {
		return itemGroupDao.get(name);
	}
	
	@Override
	public boolean save(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group cannot be null");
		return itemGroupDao.save(itemGroup);
	}

	@Override
	public boolean update(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group cannot be null");
		return itemGroupDao.update(itemGroup);
	}

	@Override
	public boolean saveOrUpdate(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group cannot be null");
		return get(itemGroup.getId()) == null ? save(itemGroup) : update(itemGroup);
	}
	
	@Override
	public List<ItemGroupDto> getItemsByItemGroupId() {
		return itemGroupDao.getItemsByItemGroupId();
	}
}
