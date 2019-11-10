package com.examSystem.service;

import com.examSystem.dao.AnswerMapper;
import com.examSystem.dao.LoginMapper;
import com.examSystem.dao.StudentMapper;
import com.examSystem.dao.TeacherMapper;
import com.examSystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    StudentService studentService;
    @Autowired
    LoginService loginService;
    @Autowired
    AnswerMapper answerMapper;
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    StudentMapper studentMapper;

    private final TeacherMapper teacherMapper;


    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public Teacher getTeacherByAccount(String account) {
        return teacherMapper.selectByAccount(account);
    }

    //添加学生，login表student表分别添加，默认密码1234
    public int addstudent(Student student) {
        return studentService.addstudent(student);
    }

    //删除学生,login,anser,student表中学生数据都会被删除
    public void delBysAccount(String sid) {
        studentMapper.delBysAccount(sid);
        loginMapper.delBysAccount(sid);
        answerMapper.delBysAccount(sid);
    }

    //添加老师，login表teacher表分别添加，默认密码1234
    public int addteacher(Teacher teacher) {
        loginService.addteacher(teacher);
        return teacherMapper.insert(teacher);
    }

    public List<Teacher> getAllTeacherTeacher(String scid){
        System.out.println(teacherMapper.getAllSchoolTeacher(scid)+"0000000"+scid);
        return teacherMapper.getAllSchoolTeacher(scid);

    }

}
