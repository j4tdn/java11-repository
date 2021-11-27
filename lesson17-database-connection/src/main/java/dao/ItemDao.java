package dao;

import persistence.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemDao {
    List<Item> get(String igName);

    List<Item> get(LocalDate date);
}
