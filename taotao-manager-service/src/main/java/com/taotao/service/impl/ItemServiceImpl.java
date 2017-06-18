package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.dao.TbItemDao;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemDao itemDao;

	public TbItem getItemById(Long iienId) {

		return itemDao.selectByPrimaryKey(iienId);
	}

}
