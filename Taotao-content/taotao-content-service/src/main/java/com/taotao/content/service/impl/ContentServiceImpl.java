package com.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.dao.TbContentDao;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentQuery;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import com.taotao.pojo.TbContentQuery.Criteria;

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

	public EasyUIDataGridResult getContentList(Long categoryId, int page, int rows) {
		// 1.设置分页信息
		PageHelper.startPage(page, rows);
		// 2.执行查询
		TbContentQuery query = new TbContentQuery();
		Criteria criteria = query.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = contentDao.selectByExample(query);
		// 3.获取查询结果
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		// 4.设置返回的json数据集
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	public TaotaoResult updateContentEdit(TbContent content) {
		Date date = new Date();
		content.setUpdated(date);
		contentDao.updateByPrimaryKey(content);
		return TaotaoResult.ok(content);
	}

	public TaotaoResult deleteContent(Long[] ids) {
		for (Long id : ids) {
			contentDao.deleteByPrimaryKey(id);
		}
		return TaotaoResult.ok();
	}

	public List<TbContent> getContentByCid(Long cid) {
		TbContentQuery query = new TbContentQuery();
		Criteria criteria = query.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentDao.selectByExample(query);
		return list;
	}

}
