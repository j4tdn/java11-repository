package dao;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();
	
	List<ItemGroup> get(String name);
	
	boolean save(ItemGroup itemGroup);
}
