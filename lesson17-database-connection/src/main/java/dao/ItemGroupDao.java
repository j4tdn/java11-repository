package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupDao {
	List<ItemGroup> getAll();

	ItemGroup get(int id);

	boolean save(ItemGroup group);

	boolean update(ItemGroup group);

	List<ItemGroup> get(String name);

	List<ItemGroupDto> getItemByItemGroups();
}
