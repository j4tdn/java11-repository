package service;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupService {

	
	List<ItemGroupDto> getItemsByItemGroupId(LocalDate timOrder);

}