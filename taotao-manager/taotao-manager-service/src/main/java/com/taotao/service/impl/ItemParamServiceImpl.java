package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.dao.TbItemParamDao;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamQuery;
import com.taotao.pojo.TbItemQuery;
import com.taotao.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamDao itemParamDao;

	public EasyUIDataGridResult getItemaramList(int page, int rows) {
		// 1.设置分页
		PageHelper.startPage(page, rows);
		// 2.执行查询
		TbItemParamQuery query = new TbItemParamQuery();
		List<TbItemParam> list = itemParamDao.selectByExample(query);
		for (TbItemParam tbItemParam : list) {
			System.out.println(tbItemParam);
		}
		// 3.获取查询结果
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());

		return result;

	}

}
