package service;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemGroupDto;

import java.util.List;

public class ItemGroupServiceImpl implements ItemGroupService {

    private ItemGroupDao itemGroupDao;

    public ItemGroupServiceImpl() {
        itemGroupDao = new ItemGroupDaoImpl();
    }

    @Override
    public List<ItemGroupDto> getAvailableItemsByGroupId() {
        return itemGroupDao.getAvailableItemsByGroupId();
    }
}
