package com.taotao.service;

import com.taotao.pojo.TbItem;

public interface ItemService {
	/* 根据商品ID查询商品信息 */
	TbItem getItemById(Long iienId);
}
