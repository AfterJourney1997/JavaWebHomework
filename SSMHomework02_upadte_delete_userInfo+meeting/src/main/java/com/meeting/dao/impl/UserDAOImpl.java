package com.meeting.dao.impl;

import com.meeting.dao.UserDAO;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {


    @Override
    public void updateUser() {
        System.out.println("更新用户信息！");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户信息！");
    }
}
