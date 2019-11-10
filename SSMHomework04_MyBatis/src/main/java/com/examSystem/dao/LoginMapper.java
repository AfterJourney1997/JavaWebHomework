package com.examSystem.dao;

import com.examSystem.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    int deleteByPrimaryKey(Integer id);

    int delBysAccount(String Account);

    int insert(Login record);

    Login selectByPrimaryKey(Integer id);

    List<Login> selectAll();

    int updateByPrimaryKey(Login record);

    List<Login> selectByIdentity(@Param("identity") Integer identity);

}