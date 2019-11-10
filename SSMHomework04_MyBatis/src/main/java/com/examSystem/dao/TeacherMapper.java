package com.examSystem.dao;

import com.examSystem.entity.Student;
import com.examSystem.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    List<Teacher> selectAll();

    List<Teacher> getAllSchoolTeacher(String scId);

    int updateByPrimaryKey(Teacher record);

    Teacher selectByAccount(@Param("account") String account);
}