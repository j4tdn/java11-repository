package service;

import java.util.List;

import dao.DetaiItemDao;
import dao.DetaiItemDaoImpl;
import persistence.DetaiItemDto;

public class DetailItemServiceImpl implements DetaiItemService{
	DetaiItemDao dao; 
	public DetailItemServiceImpl() {
		dao=new DetaiItemDaoImpl();
	}
	@Override
	public List<DetaiItemDto> get() {
		// TODO Auto-generated method stub
		return dao.get();
	}
}
