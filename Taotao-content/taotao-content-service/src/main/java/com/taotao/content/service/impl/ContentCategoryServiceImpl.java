package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.dao.TbContentCategoryDao;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryQuery;
import com.taotao.pojo.TbContentCategoryQuery.Criteria;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryDao contentCategoryDao;

	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		// 1、取查询参数Id，parentId

		// 2、根据parentId查询tb_content_category，查询子节点列表。
		TbContentCategoryQuery query = new TbContentCategoryQuery();
		Criteria criteria = query.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		// 3、得到List<TbContentCategory>
		List<TbContentCategory> list = contentCategoryDao.selectByExample(query);
		// 4、把列表转换成List<EasyUITreeNode>
		List<EasyUITreeNode> nodeList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			nodeList.add(node);
		}

		return nodeList;
	}

	public TaotaoResult addContentCategory(Long parentId, String name) {
		// 1、接收两个参数：parentId、name
		// 2、向tb_content_category表中插入数据。
		// a) 创建一个TbContentCategory对象
		TbContentCategory tbContentCategory = new TbContentCategory();
		// b) 补全TbContentCategory对象的属性
		tbContentCategory.setIsParent(false);
		tbContentCategory.setName(name);
		tbContentCategory.setParentId(parentId);
		// 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		tbContentCategory.setSortOrder(1);
		// 状态。可选值:1(正常),2(删除)
		tbContentCategory.setStatus(1);
		Date date = new Date();
		tbContentCategory.setCreated(date);
		tbContentCategory.setUpdated(date);

		// c) 向tb_content_category表中插入数据
		contentCategoryDao.insert(tbContentCategory);
		// 3、判断父节点的isparent是否为true，不是true需要改为true。
		TbContentCategory parentNode = contentCategoryDao.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			// 更新父节点
			contentCategoryDao.updateByPrimaryKey(parentNode);
		}

		// 4、需要主键返回。
		// 5、返回TaotaoResult，其中包装TbContentCategory对象

		return TaotaoResult.ok(tbContentCategory);
	}

	public TaotaoResult updateContentCategory(Long id, String name) {
		// 1、接收两个参数：parentId、name

		TbContentCategory tbContentCategory = contentCategoryDao.selectByPrimaryKey(id);

		Date date = new Date();
		tbContentCategory.setName(name);
		tbContentCategory.setUpdated(date);
		// 2、向tb_content_category表中插入数据。
		contentCategoryDao.updateByPrimaryKeySelective(tbContentCategory);
		// 3、返回TaotaoResult，其中包装TbContentCategory对象

		return TaotaoResult.ok(tbContentCategory);
	}

	public TaotaoResult deleteByIdCategory(Long id) {
		// 判断当前节点的isparent是否为true 1，直到为false为止。
		TbContentCategory node = contentCategoryDao.selectByPrimaryKey(id);
		TbContentCategory parentNode = contentCategoryDao.selectByPparentId(node.getParentId());
		if (node.getIsParent()) {
			TbContentCategory childNode = contentCategoryDao.selectByPparentId(node.getId());
			if (childNode.getIsParent()) {
				deleteByIdCategory(childNode.getId());
			} else {
				contentCategoryDao.deleteByPrimaryKey(childNode.getId());
			
				
			}
		}
		contentCategoryDao.deleteByPrimaryKey(id);
		parentNode.setIsParent(false);
		return TaotaoResult.ok();
	}

}
