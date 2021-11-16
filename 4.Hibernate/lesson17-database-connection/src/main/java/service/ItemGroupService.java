package service;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupService {
	List<ItemGroup> getAll();

	ItemGroup get(int id);

	boolean save(ItemGroup item);

	boolean update(ItemGroup itemGroup);

	boolean saveOrUpdate(ItemGroup itemGroup);
}