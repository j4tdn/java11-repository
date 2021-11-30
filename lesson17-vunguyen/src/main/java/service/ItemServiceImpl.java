package service;

import dao.ItemDao;
import dao.ItemDaoImpl;
import persistence.ItemByDateDto;
import persistence.ItemByItemGroupDto;
import persistence.ItemBySaleDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    public ItemServiceImpl() {
        itemDao = new ItemDaoImpl();
    }

    @Override
    public List<ItemByDateDto> get(LocalDate orderDate) {
        return itemDao.get(orderDate);
    }

    @Override
    public List<String> getItemBySale(int year) {
        return itemDao.get(year).stream().map(ItemBySaleDto::getName).collect(Collectors.toList());
    }

    @Override
    public List<ItemByItemGroupDto> getItemByItemGroups() {
        return itemDao.getItemByItemGroups();
    }
}
