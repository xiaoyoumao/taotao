package com.taotao.content.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.dao.TbContentDao;
import com.taotao.pojo.TbContent;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentDao contentDao;

	public TaotaoResult addContent(TbContent content) {
		// 1、把TbContent对象属性补全。
		Date date = new Date();
		content.setUpdated(date);
		content.setCreated(date);
		// 2、向tb_content表中插入数据。
		contentDao.insert(content);
		// 3、返回TaotaoResult
		return TaotaoResult.ok();
	}

}
