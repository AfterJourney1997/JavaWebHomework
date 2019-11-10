package com.examSystem.dao;

import com.examSystem.entity.School;
import com.examSystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int delByscId(String scId);

    int insert(School record);

    School selectByPrimaryKey(Integer id);

    List<School> selectAll();

    List<School> getAllSchool(String scId);

    int updateByPrimaryKey(School record);

    School selectById(@Param("schoolId") String schoolId);
}