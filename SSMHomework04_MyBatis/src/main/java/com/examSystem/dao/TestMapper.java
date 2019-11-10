package com.examSystem.dao;

import com.examSystem.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    int deleteByPrimaryKey(Integer testId);

    int insert(Test record);

    Test selectByPrimaryKey(Integer testId);

    List<Test> selectAll();

    int updateByPrimaryKey(Test record);
}