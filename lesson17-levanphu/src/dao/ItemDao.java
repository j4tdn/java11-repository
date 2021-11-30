package dao;

import java.time.LocalDate;
import java.util.List;

import persistencce.Item;

public interface ItemDao {
    List<Item> get(LocalDate orderDate);
}
