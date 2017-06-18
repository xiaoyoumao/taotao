package com.store.dao;

import com.store.pojo.Orders;
import com.store.pojo.OrdersQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersDao {
    int countByExample(OrdersQuery example);

    int deleteByExample(OrdersQuery example);

    int deleteByPrimaryKey(String oid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersQuery example);

    Orders selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersQuery example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersQuery example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}