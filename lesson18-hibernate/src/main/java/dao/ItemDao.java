package dao;

import persistence.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getAll();
    Item getItem(int itemId);
}