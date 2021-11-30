package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupService {
	List<ItemGroup> getAll();

	ItemGroup get(int id);
	
	List<ItemGroup> get(String name);
	
	List<ItemGroupDto> getItemGroupbyDateDelivery(LocalDate dateDelivery);
	
	List<ItemGroupDto> getItemGroupbyGroupId();

}
