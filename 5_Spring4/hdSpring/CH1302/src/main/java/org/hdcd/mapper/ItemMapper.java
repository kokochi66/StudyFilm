package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Item;

public interface ItemMapper {

	public void create(Item item) throws Exception;

	public Item read(Integer itemId) throws Exception;

	public void update(Item item) throws Exception;

	public void delete(Integer itemId) throws Exception;

	public List<Item> list() throws Exception;

	public String getPicture(Integer itemId) throws Exception;

}
