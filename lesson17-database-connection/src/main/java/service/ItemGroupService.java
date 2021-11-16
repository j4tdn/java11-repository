package service;

import persistence.ItemGroup;

import java.util.List;

public interface ItemGroupService {
    List<ItemGroup> getAll();

    ItemGroup get(int id);

    boolean save(ItemGroup itemGroup);

    boolean update(ItemGroup itemGroup);

    boolean saveOrUpdate(ItemGroup itemGroup);
}
