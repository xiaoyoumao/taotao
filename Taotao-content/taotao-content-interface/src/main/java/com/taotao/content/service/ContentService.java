package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	TaotaoResult addContent(TbContent content);

	EasyUIDataGridResult getContentList(Long categoryId, int page, int rows);

	TaotaoResult updateContentEdit(TbContent content);

	TaotaoResult deleteContent(Long[] ids);
	
	List<TbContent> getContentByCid(Long cid);
}
