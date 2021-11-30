package service;

import persistence.ItemByDateDto;
import persistence.ItemByItemGroupDto;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {
    List<ItemByDateDto> get(LocalDate orderDate);

    List<String> getItemBySale(int year);

    List<ItemByItemGroupDto> getItemByItemGroups();
}
