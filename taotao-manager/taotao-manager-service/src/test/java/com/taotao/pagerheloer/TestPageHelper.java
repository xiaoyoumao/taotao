package com.taotao.pagerheloer;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.dao.TbItemDao;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import com.taotao.pojo.TbItemQuery.Criteria;

/**
 * 测试PagerHelper分页
 * 
 * @author Administrator
 *
 */

public class TestPageHelper {
	@Test
	public void TestPagerHelper() {
		// 1.在Mybatis配置文件中配置PageHelper插件
		// 2.在执行分页查询值之前配置 分页条件使用PagerHelper静态方法
		PageHelper.startPage(1, 10);
		// 3.执行分页查询语句
		// 获取查询的Query对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml");
		TbItemDao itemDao = applicationContext.getBean(TbItemDao.class);
		TbItemQuery itemQuery = new TbItemQuery();
		Criteria criteria = itemQuery.createCriteria();
		List<TbItem> list = itemDao.selectByExample(itemQuery);
		// 4.使用PageInfo获取分页数据
		PageInfo<TbItem> info = new PageInfo<>(list);

		// 获取总记录数
		long total = info.getTotal();
		// 获取总页数
		int pages = info.getPages();

		// 获取返回的 记录数

		int size = list.size();
		System.out.println(total + " " + pages + " " + size);
	}
}
