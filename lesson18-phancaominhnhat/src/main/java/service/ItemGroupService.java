package service;

import java.util.List;

import persistence.ItemGroupDto;
import persistence.ItemsDto;

public interface ItemGroupService {
	List<ItemGroupDto> getAmountItemGroup();
	List<ItemsDto> getAllItemById();
}
