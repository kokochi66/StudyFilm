package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Item2;

public interface ItemService2 {

	public void regist(Item2 item) throws Exception;

	public Item2 read(Integer itemId) throws Exception;

	public void modify(Item2 item) throws Exception;

	public void remove(Integer itemId) throws Exception;

	public List<Item2> list() throws Exception;

	public String getPicture(Integer itemId) throws Exception;
	
	public String getPicture2(Integer itemId) throws Exception;

}
