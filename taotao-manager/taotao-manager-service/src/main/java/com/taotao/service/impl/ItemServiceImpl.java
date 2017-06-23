package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.dao.TbItemDao;
import com.taotao.dao.TbItemDescDao;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemQuery;
import com.taotao.pojo.TbItemQuery.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemDao itemDao;

	@Autowired
	private TbItemDescDao itemDescDao;

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

	public TaotaoResult addItem(TbItem item, String desc) {
		// 1.生成商品id
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// 2.补全TbItem对象属性
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		// 3.向商品表中插入数据
		itemDao.insert(item);
		// 4.创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		// 5.补全TbItemDesc的属性
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(itemId);
		itemDesc.setUpdated(date);
		itemDesc.setCreated(date);
		// 6.向商品描述表中添加数据
		itemDescDao.insert(itemDesc);
		// 7.TaotaoResoult.ok
		TaotaoResult ok = TaotaoResult.ok();
		return ok;
	}

	public TaotaoResult updateItem(TbItem item) {
		TbItemQuery query = new TbItemQuery();
		Criteria criteria = query.createCriteria();
		criteria.andIdEqualTo(item.getId());
		return null;
	}

	public TbItemDesc getItemDescById(Long itemId) {
		// TODO Auto-generated method stub
		return itemDescDao.selectByPrimaryKey(itemId);
	}
}
