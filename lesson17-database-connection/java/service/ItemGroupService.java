package service;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupService {
	public List<ItemGroup> getAll();

	public ItemGroup get(int id);
	
	public boolean save(ItemGroup itemGroup);
}
