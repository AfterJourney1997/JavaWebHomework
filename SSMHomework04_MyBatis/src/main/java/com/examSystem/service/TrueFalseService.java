package com.examSystem.service;

import cn.hutool.core.util.ArrayUtil;
import com.examSystem.dao.TrueFalseMapper;
import com.examSystem.entity.TrueFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class TrueFalseService {

    private final TrueFalseMapper trueFalseMapper;

    @Autowired
    public TrueFalseService(TrueFalseMapper trueFalseMapper) {
        this.trueFalseMapper = trueFalseMapper;
    }

    public List<TrueFalse> getTrueFalseList(String[] trueFalses){

        List<TrueFalse> trueFalseList = new ArrayList<>();

        for (String trueFalseId : trueFalses){
            trueFalseList.add(trueFalseMapper.selectByPrimaryKey(Integer.parseInt(trueFalseId)));
        }

        return trueFalseList;
    }
    //添加试卷，判断题部分
    public String addTestTrueFalse(){
        int i=0;
        String[] turefalse=new String[15];//存放判断题编号
        List<Integer> listtrfa = new ArrayList<Integer>();//存放判断题编号，控制题号不同
        //2.创建Random对象
        Random r2 = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while (listtrfa.size() != 15) {
            int num = r2.nextInt(trueFalseMapper.selectAll().size()) + 1;
            if (!listtrfa.contains(num)) {
                turefalse[i] = Integer.toString(num);
                i++;
                listtrfa.add(num);
            }
        }
        Collections.sort(listtrfa);
        String jointurefalse = ArrayUtil.join(turefalse, "/");
        System.out.println("判断题编号:"+jointurefalse);
        return jointurefalse;
    }
    //组装试卷，用于显示，判断题部分,参数为判断题编号；
    public List<TrueFalse> makeTrueFalse(String truefalse){
        List<TrueFalse> tfList=new ArrayList<>();
        String[] b=truefalse.split("/");
        int[] truefalseNo=new int[b.length];
        for (int i=0;i<b.length;i++) {
            truefalseNo[i] = Integer.parseInt(b[i]);
        }
        for (int k=0;k<b.length;k++){
            tfList.add(trueFalseMapper.selectByPrimaryKey(truefalseNo[k]));
        }
        return tfList;
    }
}
