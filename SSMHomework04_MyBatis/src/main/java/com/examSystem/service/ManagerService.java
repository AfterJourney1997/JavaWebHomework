package com.examSystem.service;

import com.examSystem.dao.LoginMapper;
import com.examSystem.dao.ManagerMapper;
import com.examSystem.dao.SchoolMapper;
import com.examSystem.dao.StudentMapper;
import com.examSystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    SchoolService schoolService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    ArrangeService arrangeService;

    private final ManagerMapper managerMapper;

    @Autowired
    public ManagerService(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public Manager getManagerByAccount(String account) {
        return managerMapper.selectByAccount(account);
    }

    //添加学校，只添加school表
    public int addschool(School school) {
        return schoolService.addschool(school);
    }

    //添加老师,添加login表与teacher表
    public int addteacher(Teacher teacher){
        return teacherService.addteacher(teacher);
    }

    //删除学校,school表中学校数据都会被删除
    public void delByscAccount(String scId) {
        schoolMapper.delByscId(scId);
    }

    //删除老师,login,teacher表中老师数据都会被删除
    public void delBytAccount(String tid) {
        studentMapper.delBysAccount(tid);
        loginMapper.delBysAccount(tid);
    }

    //添加考试安排,添加arrange表
    public int addarrange(Arrange arrange) {
        return arrangeService.addarrange(arrange);
    }

}
