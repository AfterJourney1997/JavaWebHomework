package com.examSystem.dao;

import com.examSystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer sId);

    int delBysAccount(String sAccount);

    int insert(Student record);

    Student selectByPrimaryKey(Integer sId);

    List<Student> selectAll();

    List<Student> getAllSchoolStudent(String scId);

    int updateByPrimaryKey(Student record);

    Student selectByAccount(@Param("account") String account);
}