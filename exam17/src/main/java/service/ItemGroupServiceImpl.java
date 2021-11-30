package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDaoImpl;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {
	private ItemGroupDaoImpl itemGroupDao;

	public ItemGroupServiceImpl() {
		itemGroupDao = new ItemGroupDaoImpl();
	}

	@Override
	public List<ItemGroup> getAll() {

		return itemGroupDao.getAll();
	}

	@Override
	public ItemGroup get(int id) {

		return itemGroupDao.get(id);
	}

	@Override
	public boolean save(ItemGroup group) {
		Objects.requireNonNull(group, "itemgroup is not null");
		return itemGroupDao.save(group);
	}

	@Override
	public boolean update(ItemGroup group) {
		Objects.requireNonNull(group, "itemgroup is not null");
		return itemGroupDao.update(group);
	}

	@Override
	public boolean saveOrUpdate(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "itemgroup is not null");
		return get(itemGroup.getId()) != null ? update(itemGroup) : save(itemGroup);
	}

	@Override
	public List<ItemGroup> get(String name) {
		return itemGroupDao.get(name);
	}

	@Override
	public List<ItemGroupDto> getItemByItemGroups() {
		return itemGroupDao.getItemByItemGroups();
	}

}
