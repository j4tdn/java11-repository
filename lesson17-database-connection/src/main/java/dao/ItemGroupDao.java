package dao;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

import java.util.List;

public interface ItemGroupDao {
    List<ItemGroup> getAll();

    ItemGroup get(int id);

    List<ItemGroup> get(String name);

    boolean save(ItemGroup itemGroup);

    boolean update(ItemGroup itemGroup);

    List<ItemGroupDto> getItemsByItemGroupId();
}
