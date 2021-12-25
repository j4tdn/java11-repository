package service;

import java.util.List;


import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupService {
	List<ItemGroup> getAll();
	
	List<ItemGroupDto> getItemsByItemGroupId();
	
	void demoSlvCache();
}
