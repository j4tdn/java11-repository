package dao;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();
	ItemGroup get(int id);
	List<ItemGroup> get(String name);
	boolean save(ItemGroup itemGroup);
	boolean update(ItemGroup itemGroup);
	
}
