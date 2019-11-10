package com.examSystem.dao;

import com.examSystem.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    Manager selectByPrimaryKey(Integer mId);

    List<Manager> selectAll();

    int updateByPrimaryKey(Manager record);

    Manager selectByAccount(@Param("account") String account);
}