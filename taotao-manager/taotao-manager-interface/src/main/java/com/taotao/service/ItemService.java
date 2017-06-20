package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	/* 根据商品ID查询商品信息 */
	TbItem getItemById(Long iienId);

	/* 分页查询获取数据集 */
	EasyUIDataGridResult getItemList(int page, int rows);
}
