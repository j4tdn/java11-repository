package dao;

import persistence.ItemByDateDto;
import persistence.ItemByItemGroupDto;
import persistence.ItemBySaleDto;

import java.time.LocalDate;
import java.util.List;

public interface ItemDao {
    List<ItemByDateDto> get(LocalDate orderDate);

    List<ItemBySaleDto> get(int year);

    List<ItemByItemGroupDto> getItemByItemGroups();
}
