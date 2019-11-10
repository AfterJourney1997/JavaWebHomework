package com.examSystem.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        String[] choice = new String[15];
        int i = 0;
        List<Integer> list = new ArrayList<Integer>();
        //2.创建Random对象
        Random r = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while (list.size() != 15) {
            int num = r.nextInt(20) + 1;
            if (!list.contains(num)) {
                choice[i] = Integer.toString(num);
                list.add(num);
                i++;
            }
        }
        Collections.sort(list);
        System.out.println(list);
        for (int k = 0; k < 15; k++) {
            System.out.println(choice[k]);
        }
    }
}
