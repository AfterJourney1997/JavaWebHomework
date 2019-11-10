package com.examSystem.service;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.examSystem.dao.ChoiceMapper;
import com.examSystem.entity.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ChoiceService {

    private final ChoiceMapper choiceMapper;

    @Autowired
    public ChoiceService(ChoiceMapper choiceMapper) {
        this.choiceMapper = choiceMapper;
    }

    public List<Choice> getChoiceList(String[] choices){

        List<Choice> choiceList = new ArrayList<>();

        for(String choiceId : choices){
            choiceList.add(choiceMapper.selectByPrimaryKey(Integer.parseInt(choiceId)));
        }

        return choiceList;
    }
    //添加试卷得到选择题部分
    public String addTestChoice() {
        int i=0;
        String[] choice=new String[15];//存放题编号
        List<Integer> listchoice = new ArrayList<Integer>();//存放选择题编号，控制题号不同
        //2.创建Random对象
        Random r = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while (listchoice.size() != 15) {
            int num = r.nextInt(choiceMapper.selectAll().size()) + 1;
            if (!listchoice.contains(num)) {
                choice[i] = Integer.toString(num);
                i++;
                listchoice.add(num);
            }
        }
        Collections.sort(listchoice);
        String joinchoice = ArrayUtil.join(choice, "/");
        System.out.println("选择题编号:"+joinchoice);
        return joinchoice;
    }
    //组装试卷，用于显示，选择题部分,参数为选择题编号；
    public List<Choice> makeChoice(String choice){
        List<Choice> list=new ArrayList<>();
        String[] a=choice.split("/");
        int[] choiceNo=new int[a.length];
        for (int i=0;i<a.length;i++) {
            choiceNo[i] = Integer.parseInt(a[i]);
        }
        for (int k=0;k<a.length;k++){
            list.add(choiceMapper.selectByPrimaryKey(choiceNo[k]));
        }
        return list;
    }
}
