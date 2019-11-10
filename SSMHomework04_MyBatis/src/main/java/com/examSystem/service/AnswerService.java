package com.examSystem.service;

import cn.hutool.core.util.ArrayUtil;
import com.examSystem.dao.AnswerMapper;
import com.examSystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AnswerService {

    private final AnswerMapper answerMapper;

    private final int OK=1;

    private final int ERROR=0;

    @Autowired
    public AnswerService(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public List<Result> getStudentResult(String sAccount){
        List<Result> results = answerMapper.selectResult(sAccount);
        return results.stream()
                .filter((e) -> e.getFraction() > 0.0001F)
                .collect(Collectors.toList());
    }

    public void insertAnswer(Answer answer){
        answerMapper.insert(answer);
    }
    //查询学生信息成绩answer表
    public List<Answer> selstudent(String account){
        return answerMapper.selectBySAccount(account);
    }
    //查询所有待批改试卷
    public List<Answer> selCorTest(){
        return answerMapper.selCorTest();
    }
    //查询删除的试卷是否存在待批改
    public int selTestCheck(int testId){
        List<Answer> list=answerMapper.selCorTest();
        for (int i=0;i<list.size();i++)
        {
            if(list.get(i).getTestId()==testId)
            {
                return ERROR;
            }
        }
        return OK;
    }
     //根据answerId查询answer表
     public Answer selectByPrimaryKey(Integer answerId){
        return answerMapper.selectByPrimaryKey(answerId);
     }
     //拆分答案字符串变成数组,选择题学生答案部分
    public String[] splitChoice(String choice){
        String[] choiceArray= choice.split("/");
        return choiceArray;
    }
    //拆分答案字符串变成数组，判断题答案部分
    public String[] splitTrueFalse(String truefalse){
        String[] truefalseArray= truefalse.split("/");
        return truefalseArray;
    }
    //拆分答案字符串变成数组，简答题答案部分
    public String[] splitShort(String shortAnswer){
        String[] shortAnswerArray= shortAnswer.split("/");
        return shortAnswerArray;
    }
    //选择，判断得分
    public int[] grade(String[] cho,String[] tru,List<Choice> liChoice,List<TrueFalse> liTrueFalse){
     int[] sum=new int[30];
     int k=15;
     for (int i=0;i<15;i++)
     {
         if(cho[i].equals(liChoice.get(i).getCqCorrect())){
             sum[i]=2;
         }else{
             sum[i]=0;
         }
     }
        for (int i=0;i<15;i++)
        {
            if(tru[i].equals(liTrueFalse.get(i).getTfqCorrect())){
                sum[k]=2;
            }else{
                sum[k]=0;
            }
            k++;
        }
        return sum;
    }
    //添加成绩
    public int addGrade(int answId,float Sum,int[] gra3){
        for (int i=0;i<gra3.length;i++)
        {
            Sum+=gra3[i];
        }
        return answerMapper.addGrade(answId,Sum);
    }

}
