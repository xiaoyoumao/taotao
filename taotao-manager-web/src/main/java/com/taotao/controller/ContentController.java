package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult createContent(TbContent content) {
		TaotaoResult result = contentService.addContent(content);
		return result;
	}

	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Long categoryId, int page, int rows) {
		EasyUIDataGridResult result = contentService.getContentList(categoryId, page, rows);

		return result;
	}

	@RequestMapping("/rest/content/edit")
	@ResponseBody
	public TaotaoResult updateContentEdit(TbContent content) {
		TaotaoResult result = contentService.updateContentEdit(content);
		return result;
	}
	
	@RequestMapping("/content/delete")
	@ResponseBody
	public TaotaoResult deleteContent(Long [] ids) {
		TaotaoResult result = contentService.deleteContent(ids);
		return result;
	}
	
}
