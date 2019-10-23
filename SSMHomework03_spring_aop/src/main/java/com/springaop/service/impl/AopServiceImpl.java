package com.springaop.service.impl;

import com.springaop.service.AopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("aopService")
public class AopServiceImpl implements AopService {

    @Override
    public void methodForAop() {
        
        System.out.println("Service method is invoking...");
    }
}
