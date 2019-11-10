/*
package com.examSystem.task;

import com.examSystem.dao.ArrangeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
public class TimingTask implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ArrangeMapper arrangeMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //root application context 没有parent，他就是老大
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){

        }
    }
}
*/
