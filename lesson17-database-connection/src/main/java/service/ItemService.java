package service;

import persistence.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {
    List<Item> get(String igName);

    List<Item> get(LocalDate orderDate);

}
