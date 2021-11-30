package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupDao {
	List<ItemGroup> getAll();

	ItemGroup get(int id);

	boolean save(ItemGroup itemGroup);

	boolean update(ItemGroup itemGroup);

	List<ItemGroup> get(String name);
	
	List<ItemGroupDto> getItemsByItemGroupId();
}
