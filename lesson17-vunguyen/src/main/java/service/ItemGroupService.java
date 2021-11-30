package service;

import persistence.ItemGroupDto;

import java.util.List;

public interface ItemGroupService {
    List<ItemGroupDto> getAvailableItemsByGroupId();
}
