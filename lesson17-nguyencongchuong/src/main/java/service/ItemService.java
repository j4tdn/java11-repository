package service;

import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemService {
	List<ItemGroup> getAll();

	ItemGroup get(int id);
	
	List<ItemGroup> get(String name);
	
	boolean save(ItemGroup itemGroup);

	boolean update(ItemGroup itemGroup);

	boolean saveOrUpdate(ItemGroup itemGroup);
	
	List<ItemDto> getItemsByItemGroupId(); 
	
	List<ItemDto> getItemGroup();
}