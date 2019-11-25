package com.mybatisSQL.dao;

import com.mybatisSQL.entity.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User> selectDynamic(Map<String, Object> params);

    int updateDynamic(User record);

    int insertDynamic(User record);

    User selectWithOrderByUserName(String username);

    User selectWithItemByUserName(String username);
}