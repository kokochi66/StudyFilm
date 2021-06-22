package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Item2;

public interface ItemMapper2 {

	public void create(Item2 item) throws Exception;

	public Item2 read(Integer itemId) throws Exception;

	public void update(Item2 item) throws Exception;

	public void delete(Integer itemId) throws Exception;

	public List<Item2> list() throws Exception;

	public String getPicture(Integer itemId) throws Exception;
	
	public String getPicture2(Integer itemId) throws Exception;
}
