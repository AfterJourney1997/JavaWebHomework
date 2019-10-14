package com.meeting.service.impl;

import com.meeting.dao.UserDAO;
import com.meeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updateUser() {
        userDao.updateUser();
    }

    @Override
    public void deleteUser() {
        userDao.deleteUser();
    }
}
