package com.examSystem.controller;

import com.examSystem.entity.Arrange;
import com.examSystem.entity.School;
import com.examSystem.entity.Teacher;
import com.examSystem.entity.Test;
import com.examSystem.service.ManagerService;
import com.examSystem.service.SchoolService;
import com.examSystem.service.TeacherService;
import com.examSystem.service.TestService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * @IDE : Intellij IDEA
 * @Author : Wu Xianzhi
 * @Date : 2019/8/4
 * @Time : 15:53
 * @Version : 1.0
 */
@Slf4j
@Controller
public class ManagerController {


    @Resource
    ManagerService managerService;
    @Resource
    SchoolService schoolService;
    @Resource
    TeacherService teacherService;
    @Resource
    TestService testService;

    /**
     * 处理school CRUD请求
     * 配置默认打开的页面
     */

    /**
     * 添加学校页面
     *
     * @return
     */
    @RequestMapping({"/schooladd"})
    public String schooladd() {
        return "addschool";
    }

    @RequestMapping("/addschool")
    public String addschool(School school, Model model) {
        if (managerService.addschool(school) > 0) {
            String out = "添加成功,学校" + school.getScName();
            model.addAttribute("model", out);
        } else {
            model.addAttribute("model", "添加失败");
        }
        return "addschool";
    }

    /**
     * 返回删除学校页面，获得全部学校
     *
     * @return
     */
    @RequestMapping({"/schooldel"})
    public String schooldel(School school, Model model) {
        model.addAttribute("sc", school);
        return "delschool";
    }

    /**
     * 删除学校
     *
     * @return
     */
    @RequestMapping("/delschool")
    public String delschool(String Id, Model model) {
        managerService.delByscAccount(Id);
        model.addAttribute("sc", Id);
        return "delschool";
    }

    /**
     * 查询学校页面
     *
     * @return
     */

    /**
     * 查询学校信息
     *
     * @return
     */

    /**
     * 处理teacher CRUD请求
     * 配置默认打开的页面
     */

    /**
     * 添加老师页面
     *
     * @return
     */
    @RequestMapping({"/teacheradd"})
    public String teacheradd() {
        return "addteacher";
    }

    @RequestMapping("/addteacher")
    public String addteacher(Teacher teacher, Model model) {
        if (managerService.addteacher(teacher) > 0) {
            String out = "添加成功,老师" + teacher.getTName() + "默认登录密码为“1234”";
            model.addAttribute("model", out);
            model.addAttribute("model", out);
        } else {
            model.addAttribute("model", "添加失败");
        }
        return "addteacher";
    }

    /**
     * 删除老师页面，获得全部老师
     *
     * @return
     */
    @RequestMapping({"/teacherdel"})
    public String teacherdel(String tid, Model model) {
        List<Teacher> t = teacherService.getAllTeacherTeacher(tid);
        model.addAttribute("t", t);
        return "delteacher";
    }

    /**
     * 删除老师
     *
     * @return
     */
    @RequestMapping("/delteacher")
    public String delstudent(String tId, String scid, Model model) {
        managerService.delBytAccount(tId);
        List<Teacher> t = teacherService.getAllTeacherTeacher(scid);
        model.addAttribute("t", t);
        return "delteacher";
    }

    /**
     * 进入添加考试安排页面
     *
     * @return
     */
    @RequestMapping({"/arrangeadd"})
    public String arrangeadd(Model model) {
        List<School> sc = schoolService.selectAll();
        model.addAttribute("schools", sc);
        List<Test> ts = testService.selectAll();
        model.addAttribute("test", ts);
        return "manager/addarrange";
    }

    /**
     * 添加考试安排
     *
     * @return
     */
    @RequestMapping("/addarrange")
    public String addarrange(@NonNull String testId, @NonNull String scId,
                             @NonNull String arrName,
                             @NonNull String arrStart, @NonNull String arrStop,
                             @NonNull String arrStatus,
                             Model model) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss");

        Arrange arrange = new Arrange();
        arrange.setArrId(null);
        arrange.setTestId(Integer.parseInt(testId));
        arrange.setScId(scId);
        arrange.setArrName(arrName);
        arrange.setArrStatus(Integer.parseInt(arrStatus));
        arrange.setArrStart(LocalDateTime.parse(arrStart, dateTimeFormatter));
        arrange.setArrStop(LocalDateTime.parse(arrStop, dateTimeFormatter));

        LocalDateTime now = LocalDateTime.now();
        if(now.isAfter(arrange.getArrStart())){
            arrange.setArrStatus(1);
        }

        if (managerService.addarrange(arrange) > 0) {
            String out = "添加成功,考试安排" + arrange.getArrName();
            model.addAttribute("model", out);
            log.info("管理员添加考试成功:{}", arrange);
        } else {
            model.addAttribute("model", "添加失败");
        }
        return "manager/addarrange";
    }

}