package dao;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

import java.util.List;

public interface ItemGroupDao {
     void demoSlvCache();

    List<ItemGroup> getAll();

    List<ItemGroupDto> getItemByItemGroupId();
}
