package com.examSystem.service;

import com.examSystem.dao.SchoolMapper;
import com.examSystem.entity.School;
import com.examSystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;

    @Autowired
    public SchoolService(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    public School getSchoolById(String schoolId) {
        return schoolMapper.selectById(schoolId);
    }

    //添加学校,只添加school表
    public int addschool(School school) {
        return schoolMapper.insert(school);
    }

    //获得所有学校
    public List<School> getAllSchool(String scId) {
        System.out.println(schoolMapper.getAllSchool(scId) + "0000000"
                + scId);
        return schoolMapper.getAllSchool(scId);
    }

    public List<School> selectAll() {
        return schoolMapper.selectAll();
    }
}
