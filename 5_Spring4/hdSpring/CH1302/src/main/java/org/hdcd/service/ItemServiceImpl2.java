package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Item2;
import org.hdcd.mapper.ItemMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl2 implements ItemService2 {

	@Autowired
	private ItemMapper2 mapper;

	@Override
	public void regist(Item2 item) throws Exception {
		mapper.create(item);
	}

	@Override
	public Item2 read(Integer itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item2 item) throws Exception {
		mapper.update(item);
	}

	@Override
	public void remove(Integer itemId) throws Exception {
		mapper.delete(itemId);
	}

	@Override
	public List<Item2> list() throws Exception {
		return mapper.list();
	}

	@Override
	public String getPicture(Integer itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	@Override
	public String getPicture2(Integer itemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
