package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById1(@PathVariable Long itemId) {
		// 根据商品id查询商品信息
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(int page, int rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult addItem(TbItem item, String desc) {
		TaotaoResult result = itemService.addItem(item, desc);
		return result;

	}

	// 加载商品描述
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public TbItemDesc getItemDescById(@PathVariable Long itemId) {
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		return itemDesc;
	}
	// 加载商品规格

	@RequestMapping("/rest/item/param/item/query/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		// 根据商品id查询商品信息
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
}
