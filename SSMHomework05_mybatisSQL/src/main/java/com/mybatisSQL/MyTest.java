package com.mybatisSQL;

import com.mybatisSQL.dao.OrderMapper;
import com.mybatisSQL.dao.UserMapper;
import com.mybatisSQL.entity.Order;
import com.mybatisSQL.entity.User;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MyTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void selectDynamic(){

        List<Integer> id = new ArrayList<>();
        id.add(1);
        id.add(10);
        id.add(16);
        id.add(22);
        id.add(24);

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", "王");

        List<User> users = userMapper.selectDynamic(map);

        users.forEach(System.out::println);
    }

    @Test
    public void updateDynamic(){
        User user = new User(10, "王柳", null, null, null, null);
        userMapper.updateDynamic(user);
    }

    @Test
    public void insertDynamic(){
        User user = new User(null, "zz", null, null, null, null);
        userMapper.insertDynamic(user);
    }

    @Test
    public void orderSelectWithUser(){
        List<Order> orders = orderMapper.selectWithUser(3);
        orders.forEach(System.out::println);
    }

    @Test
    public void selectWithOrderByUserName(){
        User user = userMapper.selectWithOrderByUserName("王五");
        System.out.println(user);

    }

    @Test
    public void selectWithItemByUserName(){
        User user = userMapper.selectWithItemByUserName("王五");
        System.out.println(user);
    }

}
