package service;

import java.util.List;

import persistence.ItemGroupDto;

public interface ItemGroupService {
	List<ItemGroupDto> getItemsByItemGroup();
}