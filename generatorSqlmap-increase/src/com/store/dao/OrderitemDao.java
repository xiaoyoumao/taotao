package com.store.dao;

import com.store.pojo.Orderitem;
import com.store.pojo.OrderitemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderitemDao {
    int countByExample(OrderitemQuery example);

    int deleteByExample(OrderitemQuery example);

    int deleteByPrimaryKey(String itemid);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    List<Orderitem> selectByExample(OrderitemQuery example);

    Orderitem selectByPrimaryKey(String itemid);

    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemQuery example);

    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemQuery example);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
}