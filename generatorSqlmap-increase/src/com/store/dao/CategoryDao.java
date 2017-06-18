package com.store.dao;

import com.store.pojo.Category;
import com.store.pojo.CategoryQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryDao {
    int countByExample(CategoryQuery example);

    int deleteByExample(CategoryQuery example);

    int deleteByPrimaryKey(String cid);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryQuery example);

    Category selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryQuery example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryQuery example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}