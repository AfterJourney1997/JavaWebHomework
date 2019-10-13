package com.meeting;

import com.meeting.entity.Meeting;
import com.meeting.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MyTest {

    @Autowired
    private UserService userService;

    @Test
    public void test2(){
        ApplicationContext path = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Meeting bean = (Meeting) path.getBean("meeting");
        System.out.println(bean);
    }

    @Test
    public void test1(){
        userService.deleteUser();
        userService.updateUser();
    }

}
