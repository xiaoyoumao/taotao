package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

public interface ItemService {
	/* 根据商品ID查询商品信息 */
	TbItem getItemById(Long iienId);

	/* 分页查询获取数据集 */
	EasyUIDataGridResult getItemList(int page, int rows);

	/* 添加商品信息 */
	TaotaoResult addItem(TbItem item, String desc);

	/* 通过id修改更新商品信息 */
	TaotaoResult updateItem(TbItem item);

	/* 根据商品ID查询商品描述信息 */
	TbItemDesc getItemDescById(Long itemId);
}
