package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/rest/page/item-edit")
	public String showItemedit() {

		return "item-edit";

	}

	// 加载商品描述

	@RequestMapping("/rest/item/query/item/desc/{id}")
	@ResponseBody
	public TaotaoResult getItemDescById(@PathVariable(value = "id") Long itemDescId) {

		TaotaoResult result = itemService.getItemDescById(itemDescId);
		return result;
	}
	// 加载商品规格

	@RequestMapping("/rest/item/param/item/query/{id}")
	@ResponseBody
	public TaotaoResult getItemById(@PathVariable(value = "id") Long itemId) {

		// 根据商品id查询商品信息
		TaotaoResult result = itemService.getItemById(itemId);
		return result;
	}

	@RequestMapping("/rest/item/update")
	@ResponseBody
	public TaotaoResult updateItem(TbItem item, String desc) {
		TaotaoResult result = itemService.updateItem(item, desc);
		return result;
	}

	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public TaotaoResult deleteItem(Long[] ids) {
		TaotaoResult result = itemService.deleteItem(ids);
		return result;
	}

	// 下架
	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public TaotaoResult updateInstock(Long[] ids) {
		TaotaoResult result = itemService.updateInstock(ids);
		return result;
	}

	// 上架
	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public TaotaoResult updateeshelf(Long[] ids) {
		TaotaoResult result = itemService.updateeshelf(ids);
		return result;
	}
	
	
}
