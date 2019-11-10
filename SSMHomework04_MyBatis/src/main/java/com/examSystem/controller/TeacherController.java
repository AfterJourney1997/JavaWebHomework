package com.examSystem.controller;

import com.examSystem.entity.*;
import com.examSystem.entity.Student;
import com.examSystem.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 这里配置默认可以打开的页面
 */
@Slf4j
@Controller
public class TeacherController {
    @Resource
    ChoiceService choiceService;
    @Resource
    TrueFalseService trueFalseService;
    @Resource
    ShortAnswerService shortAnswerService;
    @Resource
    AnswerService answerService;
    @Resource
    TeacherService ts;
    @Resource
    StudentService studentService;
    @Resource
    TestService testService;

    /**
     * 进入添加学生页面
     * @return
     */
    @RequestMapping(value = "/studentadd")
    public String studentadd(){
        return "addstudent";
    }

    /**
     * 删除学生页面，获得全部学生
     * @return
     */
    @RequestMapping(value = "/studentdel")
    public String studentdel(String scid,Model model){
        List<Student> students = studentService.getAllStudentStudent(scid);
        model.addAttribute("students",students);
        return "delstudent";
    }

    /**
     * 查询学生页面
     * @return
     */
    @RequestMapping(value = "/studentsel" )
    public String studentsel(){
        return "selstudent";
    }
    /**
     * 打开添加试卷页面
     * @return
     */
    @RequestMapping(value = "/testadd")
    public String testadd(){
        return "testadd";
    }
    /**
     * 打开删除试卷页面，查询所有试卷
     * @return
     */
    @RequestMapping(value = "/testdel")
    public String testdel(Model model){
    List<Test> listAllTest=testService.getAllTest();
    model.addAttribute("listAllTest",listAllTest);
        return "testdel";
    }
    /**
     * 打开删除试卷详情页面，查询该试卷
     * @return
     */
    @RequestMapping(value = "/looktest")
    public String looktest(String testId, Model model){
        int tSd =Integer.parseInt(testId);
        Test test=testService.getTest(tSd);
        List<Choice> listChoice=choiceService.makeChoice(test.getCqId());
        List<TrueFalse> listTrueFalse=trueFalseService.makeTrueFalse(test.getTfqId());
        List<ShortAnswer> listShort=shortAnswerService.makeShortAnswer(test.getSaqId());
        model.addAttribute("listChoice",listChoice);
        model.addAttribute("listTrueFalse",listTrueFalse);
        model.addAttribute("listShort",listShort);
        model.addAttribute("test",test);
        return "looktest";
    }
    /**
     * 打开待批改试卷页
     * @return
     */
    @RequestMapping(value = "/testcor")
    public String testcor(Model model){
        List<Answer> corTest=answerService.selCorTest();
        if (corTest.size()<1)
        {
            model.addAttribute("mes","试卷已经批改完，老师辛苦了！");
        }
        model.addAttribute("corTest",corTest);
        return "testcor";
    }
    /**
     * 批改试卷页
     * @return
     */
    @RequestMapping(value = "/correctPapers")
    public String correctPapers(String answerId,Model model,HttpSession session){
        int ansId=Integer.parseInt(answerId);
        Answer answer=answerService.selectByPrimaryKey(ansId);
        Test test=testService.getTest(answer.getTestId());

        List<Choice> listChoice=choiceService.makeChoice(test.getCqId());
        List<TrueFalse> listTrueFalse=trueFalseService.makeTrueFalse(test.getTfqId());
        List<ShortAnswer> listShort=shortAnswerService.makeShortAnswer(test.getSaqId());

        String[] choiceArray=answerService.splitChoice(answer.getCqAnswer());
        String[] truefalseArray=answerService.splitTrueFalse(answer.getTfqAnswer());
        String[] shortAnswerArray=answerService.splitShort(answer.getSaqAnswer());

        int[] gradeArarry=answerService.grade(choiceArray,truefalseArray,listChoice,listTrueFalse);

        model.addAttribute("listChoice",listChoice);
        model.addAttribute("listTrueFalse",listTrueFalse);
        model.addAttribute("listShort",listShort);
        model.addAttribute("choiceArray",choiceArray);
        model.addAttribute("truefalseArray",truefalseArray);
        model.addAttribute("shortAnswerArray",shortAnswerArray);
        model.addAttribute("answer",answer);
        session.setAttribute("gradeArarry",gradeArarry);
        return "correctPapers";
    }
    /**
     * 查询学生信息
     * @return
     */
    @RequestMapping(value = "/selstudent")
    public String selstudent(String sid,Model model,HttpSession session){

        List<Answer> stums =answerService.selstudent(sid);
        if(stums.size()<1)
        {
            Student student=studentService.getStudentByAccount(sid);

            model.addAttribute("stu",student);
            session.setAttribute("ms","该学生未参加考试");
            return "selstudentmg1";//学生没有参加考试则跳至此页面
        }else {
            model.addAttribute("stums",stums);
            return "selstudentmg";//学生参加考试则跳此页面
        }

    }
    /**
     * 添加学生
     * @return
     */
    @RequestMapping(value = "/addstudent")
    public String addstudent(Student student, Model model){
        if(ts.addstudent(student)>0)
        {
            String out="添加成功,学生"+student.getSName()+"默认登录密码为“1234”";
            model.addAttribute("model",out);
        }else {
            model.addAttribute("model","添加失败");
        }
        return "addstudent";
    }
    /**
     * 删除学生
     * @return
     */
    @RequestMapping(value = "/delstudent")
    public String delstudent(String sId,String scid,Model model){
        ts.delBysAccount(sId);
        List<Student> stu= studentService.getAllStudentStudent(scid);
        model.addAttribute("stu",stu);
        return "delstudent";
    }
    /**
     * 生成试卷
     * @return
     */
    @RequestMapping("/addtest")
    public String addtest(Model model,HttpSession session){
      String Choice=choiceService.addTestChoice();
      String TrueFalse =trueFalseService.addTestTrueFalse();
      String Short=shortAnswerService.addTestShort();
      List<Choice> listChoice=choiceService.makeChoice(Choice);
      List<TrueFalse> listTrueFalse=trueFalseService.makeTrueFalse(TrueFalse);
      List<ShortAnswer> listShort=shortAnswerService.makeShortAnswer(Short);
      session.setAttribute("Choice",Choice);
      session.setAttribute("TrueFalse",TrueFalse);
      session.setAttribute("Short",Short);
      model.addAttribute("listChoice",listChoice);
      model.addAttribute("listTrueFalse",listTrueFalse);
      model.addAttribute("listShort",listShort);

      log.info("生成试卷：" + listShort.get(0).getSaqContent()+"******"+listShort.get(0).getSaqCorrect());
        return "addtest";
    }
    /**
     * 添加试卷
     * @return
     */
    @RequestMapping(value = "/inserttest")
    public String inserttest(String testname,HttpSession session,Model model){
        String Choice=(String)session.getAttribute("Choice");
        String TrueFalse=(String)session.getAttribute("TrueFalse");
        String Short=(String)session.getAttribute("Short");
        if(testService.inserttest(testname,Choice,TrueFalse,Short)>0)
        {
            model.addAttribute("mg","添加试卷成功");
        }
        return "testadd";
    }
    /**
     * 删除试卷
     * @return
     */
    @RequestMapping(value = "/deltest")
    public String deltest(String testId,Model model){
        int tSd=Integer.parseInt(testId);
        if(answerService.selTestCheck(tSd)<1)
        {
            model.addAttribute("mg","删除失败，存在未批改改试卷的学生");
        }else {
            testService.deltest(tSd);
            model.addAttribute("mg","删除成功");
        }
        List<Test> listAllTest=testService.getAllTest();
        model.addAttribute("listAllTest",listAllTest);
        return "testdel";
    }

    /**
     * 添加成绩
     * @return
     */
    @RequestMapping(value = "/addgrade")
    public String addgrade(String grade1,String grade2,String ansId,HttpSession session,Model model)
    {
        float Sum=0;
        int answId=Integer.parseInt(ansId);
        int gra1=Integer.parseInt(grade1);
        int gra2=Integer.parseInt(grade2);
        int[] gra3= (int[]) session.getAttribute("gradeArarry");
        Sum=gra1+gra2;
        answerService.addGrade(answId,Sum,gra3);
        Answer stuAnswer= answerService.selectByPrimaryKey(answId);
        List<Answer> corTest=answerService.selCorTest();
        model.addAttribute("corTest",corTest);
        String mg="批改成功，学号："+stuAnswer.getSAccount()+"，姓名："+stuAnswer.getSName()+"成绩为："+stuAnswer.getSResult();
        model.addAttribute("mg",mg);
        if (corTest.size()<1)
        {
            model.addAttribute("mes","试卷已经批改完，老师辛苦了！");
        }
        return "testcor";
    }

}
