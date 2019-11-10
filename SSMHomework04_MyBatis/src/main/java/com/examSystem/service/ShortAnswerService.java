package com.examSystem.service;

import cn.hutool.core.util.ArrayUtil;
import com.examSystem.dao.ShortAnswerMapper;
import com.examSystem.entity.ShortAnswer;
import com.examSystem.entity.TrueFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ShortAnswerService {

    private final ShortAnswerMapper shortAnswerMapper;

    @Autowired
    public ShortAnswerService(ShortAnswerMapper shortAnswerMapper) {
        this.shortAnswerMapper = shortAnswerMapper;
    }

    public List<ShortAnswer> getShortAnswerList(String[] shortAnswers){

        List<ShortAnswer> trueFalseList = new ArrayList<>();

        for (String shortAnswerId : shortAnswers){
            trueFalseList.add(shortAnswerMapper.selectByPrimaryKey(Integer.parseInt(shortAnswerId)));
        }

        return trueFalseList;
    }
    //添加试卷，简答题部分
    public String addTestShort(){
        int i=0;
        String[] Short=new String[2];//存放简答题编号
        List<Integer> listShort = new ArrayList<Integer>();//存放简答题编号，控制题号不同
        Random r3 = new Random();
        while (listShort.size() != 2) {
            int num = r3.nextInt(shortAnswerMapper.selectAll().size()) + 1;
            if (!listShort.contains(num)) {
                Short[i] = Integer.toString(num);
                i++;
                listShort.add(num);
            }
        }
        Collections.sort(listShort);
        String joinShort = ArrayUtil.join(Short, "/");
        System.out.println("简答题编号list:"+listShort);
        System.out.println("简答题编号:"+joinShort);
        return joinShort;
     }
    //组装试卷，用于显示，简答题部分,参数为简答题编号；
    public List<ShortAnswer> makeShortAnswer(String Short){
        List<ShortAnswer> shortList=new ArrayList<>();
        String[] c=Short.split("/");
        int[] ShortNo=new int[c.length];
        for (int i=0;i<c.length;i++) {
            ShortNo[i] = Integer.parseInt(c[i]);
        }
        for (int k=0;k<c.length;k++){
            shortList.add(shortAnswerMapper.selectByPrimaryKey(ShortNo[k]));
        }
        return shortList;
    }
}
