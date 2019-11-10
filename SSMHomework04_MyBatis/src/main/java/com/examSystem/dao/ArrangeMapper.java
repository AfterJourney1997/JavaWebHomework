package com.examSystem.dao;

import com.examSystem.entity.Arrange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArrangeMapper {
    int deleteByPrimaryKey(Integer arrId);

    int deleteByPrimaryKeyTest(Integer testId);

    int insert(Arrange record);

    Arrange selectByPrimaryKey(Integer arrId);

    List<Arrange> selectAll();

    int updateByPrimaryKey(Arrange record);

    List<Arrange> selectBySchoolId(@Param("schoolId") String schoolId);

}