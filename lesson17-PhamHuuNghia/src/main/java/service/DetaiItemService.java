package service;

import java.util.List;

import dao.DetaiItemDao;
import dao.DetaiItemDaoImpl;
import persistence.DetaiItemDto;

public interface DetaiItemService {
	public List<DetaiItemDto> get();
}
