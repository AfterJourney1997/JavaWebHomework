package com.chapter_1.service.impl;

import com.chapter_1.dao.UserDAO;
import com.chapter_1.service.UserService;
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
