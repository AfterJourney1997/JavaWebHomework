package com.examSystem.service;

import com.examSystem.dao.LoginMapper;
import com.examSystem.dao.ManagerMapper;
import com.examSystem.dao.StudentMapper;
import com.examSystem.dao.TeacherMapper;
import com.examSystem.entity.Login;
import com.examSystem.entity.Student;
import com.examSystem.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginMapper loginMapper;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final ManagerMapper managerMapper;
    Login login=new Login();

    @Autowired
    public LoginService(LoginMapper loginMapper, StudentMapper studentMapper, TeacherMapper teacherMapper, ManagerMapper managerMapper) {
        this.loginMapper = loginMapper;
        this.studentMapper = studentMapper;
        this.teacherMapper = teacherMapper;
        this.managerMapper = managerMapper;
    }

    public Optional<Login> checkLogin(Login login){

        List<Login> logins = loginMapper.selectByIdentity(login.getIdentity());

        return logins.stream()
                .filter((e) -> login.getAccount().equals(e.getAccount()) && login.getPassword().equals(e.getPassword()))
                .findFirst();

    }
    //login表添加学生
    public int addstudent(Student student){
        login.setAccount(student.getSAccount());
        login.setIdentity(1);
        login.setPassword("1234");
        return loginMapper.insert(login);
    }

    //login表添加老师
    public int addteacher(Teacher teacher) {
        login.setAccount(teacher.getTAccount());
        login.setIdentity(1);
        login.setPassword("1234");
        return loginMapper.insert(login);
    }
}
