package dao;

import persistence.ItemGroupDto;

import java.util.List;

public interface ItemGroupDao {
    List<ItemGroupDto> getAvailableItemsByGroupId();
}
