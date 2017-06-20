package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.dao.TbItemCatDao;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatQuery;
import com.taotao.pojo.TbItemCatQuery.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatDao itemCatDao;

	public List<EasyUITreeNode> getItemCatList(Long parentId) {
		// 1.根据父节点id查询子节点信息
		TbItemCatQuery query = new TbItemCatQuery();
		// 2.设置查询条件
		Criteria criteria = query.createCriteria();
		// 3.设置parentId
		criteria.andParentIdEqualTo(parentId);
		// 4执行查询获取数据
		List<TbItemCat> list = itemCatDao.selectByExample(query);
		// 5.转换成EasyUITreeNode

		List<EasyUITreeNode> nodeList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			// 5.1 如果节点下有子节点‘closed’ 没有子节点为‘open’
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			nodeList.add(node);
		}
		return nodeList;
	}

}
