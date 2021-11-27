package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupDao {
	List<ItemGroup> getALL();
	
	ItemGroup get(int id);
	
	List<ItemGroup> get(String name);

	boolean save(ItemGroup itemGroup);
	
	boolean update(ItemGroup itemGroup);
	
	boolean saveOrUpdate(ItemGroup itemGroup);
	
	List<ItemGroupDto> getItemsByItemGroupId();
}
