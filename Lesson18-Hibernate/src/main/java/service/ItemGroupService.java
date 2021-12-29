package service;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

import java.util.List;

public interface ItemGroupService {
    List<ItemGroup> getAll();
    List<ItemGroupDto> getItemByItemGroupId();

    void demoSlvCache();
}
