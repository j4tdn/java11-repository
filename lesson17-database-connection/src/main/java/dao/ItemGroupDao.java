package dao;

import persistence.ItemGroup;

import java.util.List;

public interface ItemGroupDao {
    List<ItemGroup> getAll();

    ItemGroup get(int id);

    boolean save(ItemGroup itemGroup);

    boolean update(ItemGroup itemGroup);
}
