package com.examSystem.controller;

import cn.hutool.core.util.StrUtil;
import com.examSystem.entity.*;
import com.examSystem.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes(value = {"user", "school", "identity"})
public class LoginController {

    private final HttpServletRequest request;
    private final LoginService loginService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final ManagerService managerService;
    private final SchoolService schoolService;

    @Autowired
    public LoginController(HttpServletRequest request, LoginService loginService, StudentService studentService, TeacherService teacherService, ManagerService managerService, SchoolService schoolService) {
        this.request = request;
        this.loginService = loginService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.managerService = managerService;
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Model model, String username, String password, int identity) {

        log.info("用户登录，账号：" + username + "，密码：" +password + "，身份：" + identity);

        if(StrUtil.isEmpty(username) || StrUtil.isEmpty(password)){
            model.addAttribute("info", "账号或密码不能为空");
            log.info("登录账号密码为空");
            return new ModelAndView("login");
        }

        Login login = new Login();
        login.setIdentity(identity);
        login.setAccount(username);
        login.setPassword(password);

        Optional<Login> checkLogin = loginService.checkLogin(login);

        // 账号或密码错误
        if(!checkLogin.isPresent()){
            model.addAttribute("info", "账号或密码错误！");
            log.info("登录账号密码错误");
            return new ModelAndView("login");
        }

        if(identity == 1){
            Student student = studentService.getStudentByAccount(checkLogin.get().getAccount());
            School school = schoolService.getSchoolById(student.getScId());
            model.addAttribute("identity", 1);
            model.addAttribute("user", student);
            model.addAttribute("school", school);
            log.info("学生登录：{}",student);
            return new ModelAndView("student/student");
        }

        if(identity == 2){
            Teacher teacher = teacherService.getTeacherByAccount(checkLogin.get().getAccount());
            School school = schoolService.getSchoolById(teacher.getScId());
            model.addAttribute("identity", 2);
            model.addAttribute("user", teacher);
            model.addAttribute("school", school);
            log.info("教师登录：{}",teacher);
            return new ModelAndView("teacher");
        }

        if(identity == 3){
            Manager manager = managerService.getManagerByAccount(checkLogin.get().getAccount());
            model.addAttribute("identity", 3);
            model.addAttribute("user", manager);
            log.info("管理员登录：{}",manager);
            return new ModelAndView("manager/manager");
        }

        return new ModelAndView();

    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public ModelAndView exit(){
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("school", null);
        request.getSession().setAttribute("identity", null);

        return new ModelAndView("login");
    }
}
