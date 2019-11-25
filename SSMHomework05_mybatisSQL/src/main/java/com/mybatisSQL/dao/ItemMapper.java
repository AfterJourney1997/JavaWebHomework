package com.mybatisSQL.dao;

import com.mybatisSQL.entity.Item;
import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    Item selectByPrimaryKey(Integer id);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);
}