package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.dao.TbItemDao;
import com.taotao.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemDao itemDao;

	public TbItem getItemById(Long iienId) {

		return itemDao.selectByPrimaryKey(iienId);
	}

	public EasyUIDataGridResult getItemList(int page, int rows) {
		// 1.设置分页信息
		PageHelper.startPage(page, rows);
		// 2.执行查询
		TbItemQuery query = new TbItemQuery();
		List<TbItem> list = itemDao.selectByExample(query);
		// 3.获取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		// 4.设置返回的json数据集
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
