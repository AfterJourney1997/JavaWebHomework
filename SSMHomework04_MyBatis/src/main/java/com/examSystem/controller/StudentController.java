package com.examSystem.controller;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.examSystem.entity.*;
import com.examSystem.service.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Controller
@RequestMapping("/student")
@SessionAttributes(value = {"examInfo"})
public class StudentController {

    private final HttpServletRequest request;
    private final ArrangeService arrangeService;
    private final AnswerService answerService;
    private final TestService testService;
    private final ChoiceService choiceService;
    private final TrueFalseService trueFalseService;
    private final ShortAnswerService shortAnswerService;

    @Autowired
    public StudentController(HttpServletRequest request, ArrangeService arrangeService,
                             AnswerService answerService, TestService testService, ChoiceService choiceService,
                             TrueFalseService trueFalseService, ShortAnswerService shortAnswerService) {
        this.request = request;
        this.arrangeService = arrangeService;
        this.answerService = answerService;
        this.testService = testService;
        this.choiceService = choiceService;
        this.trueFalseService = trueFalseService;
        this.shortAnswerService = shortAnswerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String studentHomePage(){
        return "student/student";
    }

    @RequestMapping(value = "/examInfo", method = RequestMethod.GET)
    public ModelAndView getStudentExam(Model model) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        List<Arrange> arranges = arrangeService.getArrangeBySchool(student.getScId());
        List<Answer> answers = answerService.selstudent(student.getSAccount());
        List<Arrange> arrangeList = new ArrayList<>();

        // 查询有无该学生已考过的考试
        CopyOnWriteArrayList<Arrange> tempList = new CopyOnWriteArrayList<>(arranges);
        for(Answer answer : answers){
            for(Arrange arrange : tempList){
                if(arrange.getArrId().equals(answer.getArrId())){
                    System.err.println(arrange);
                    tempList.removeIf((e) -> e.getArrId().equals(arrange.getArrId()));
                    arrange.setArrStatus(2);
                    arrangeList.add(arrange);
                }
            }
        }

        arrangeList.addAll(tempList);
        log.info("查询考试：{}", arrangeList);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        model.addAttribute("dateTimeFormatter", dateTimeFormatter);
        model.addAttribute("exam", arrangeList);
        return new ModelAndView("student/examInfo");
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView getStudentResult(Model model) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        List<Result> studentResult = answerService.getStudentResult(student.getSAccount());
        log.info("查询成绩：{}", studentResult);
        model.addAttribute("result", studentResult);
        return new ModelAndView("student/result");
    }

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public ModelAndView exam(Model model, int arrId, int testId) {

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        Arrange arrange = arrangeService.getArrange(arrId);
        Test test = testService.getTest(testId);
        log.info("考试信息：{}", arrange);
        // 获取选择题、判断题、简答题id
        String[] choices = test.getCqId().split("/");
        String[] trueFalses = test.getTfqId().split("/");
        String[] shortAnswers = test.getSaqId().split("/");

        List<Choice> choiceList = choiceService.getChoiceList(choices);
        List<TrueFalse> trueFalseList = trueFalseService.getTrueFalseList(trueFalses);
        List<ShortAnswer> shortAnswerList = shortAnswerService.getShortAnswerList(shortAnswers);

        model.addAttribute("examInfo", arrange);
        model.addAttribute("choice", choiceList);
        model.addAttribute("trueFalse", trueFalseList);
        model.addAttribute("shortAnswer", shortAnswerList);

        return new ModelAndView("student/exam");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submitExam(@NonNull String json) {

        JSONObject jsonObject = JSON.parseObject(json);

        List<String> choiceList = new ArrayList<>();
        List<String> trueFalseList = new ArrayList<>();
        List<String> shortAnswerList = new ArrayList<>();

        for(int i = 1; i <= 15; i ++){
            choiceList.add(jsonObject.getString("cq" + i));
            trueFalseList.add(jsonObject.getString("tfq" + i));
        }

        for (int i = 1; i <= 2; i++){
            shortAnswerList.add(jsonObject.getString("saq" + i));
        }

        // 获取session中的用户值
        Object user = request.getSession().getAttribute("user");
        Student student = (Student) user;

        // 获取session中考试信息
        Object exam = request.getSession().getAttribute("examInfo");
        Arrange arrange = (Arrange)exam;

        String choices = ArrayUtil.join(choiceList.toArray(new String[0]), "/");
        String trueFalses = ArrayUtil.join(trueFalseList.toArray(new String[0]), "/");
        String shortAnswers = ArrayUtil.join(shortAnswerList.toArray(new String[0]), "/");

        Answer answer = new Answer();
        answer.setAnswerId(null);
        answer.setArrId(arrange.getArrId());
        answer.setTestId(arrange.getTestId());
        answer.setSAccount(student.getSAccount());
        answer.setSName(student.getSName());
        answer.setCqAnswer(choices);
        answer.setTfqAnswer(trueFalses);
        answer.setSaqAnswer(shortAnswers);
        answer.setSResult(null);

        answerService.insertAnswer(answer);
        log.info("学生交卷：{}", answer);

        return new ModelAndView("student/finish");
    }


}
