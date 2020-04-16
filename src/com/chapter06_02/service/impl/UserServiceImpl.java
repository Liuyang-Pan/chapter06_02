package com.chapter06_02.service.impl;

import com.chapter06_02.dao.UserDao;
import com.chapter06_02.domain.User;
import com.chapter06_02.domain.Users;
import com.chapter06_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Users> listUsersByCondition(String field, String value) {
        return userDao.listUsersByCondition(field, value);
    }

    @Override
    public boolean doLogin(String name, String pwd) {
        return userDao.doLogin(name, pwd);
    }

    @Override
    public boolean doUpdate(String field, String value, String loginId, String loginPwd) {
        return userDao.doUpdate(field, value, loginId, loginPwd);
    }

    @Override
    public boolean doRegister(String name, String onePassword, String twoPassword) {
        return userDao.doRegister(name, onePassword, twoPassword);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public List<Users> findListUsersByCondition(String field, String value) {
        return userDao.findListUsersByCondition(field, value);
    }
}
