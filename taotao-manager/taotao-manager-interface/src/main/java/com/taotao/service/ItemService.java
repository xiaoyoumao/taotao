package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

public interface ItemService {
	/* 根据商品ID查询商品信息 */
	

	/* 分页查询获取数据集 */
	EasyUIDataGridResult getItemList(int page, int rows);

	/* 添加商品信息 */
	TaotaoResult addItem(TbItem item, String desc);

	/* 根据商品ID查询商品描述信息 */
	TaotaoResult getItemDescById(Long itemId);
	
	TaotaoResult getItemById(Long itemId);

	TaotaoResult updateItem(TbItem item, String desc);

	TaotaoResult deleteItem(Long[] ids);

	TaotaoResult updateInstock(Long[] ids);

	TaotaoResult updateeshelf(Long[] ids);

	
}
