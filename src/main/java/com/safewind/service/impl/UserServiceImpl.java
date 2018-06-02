package com.safewind.service.impl;

import com.safewind.dao.UserDao;
import com.safewind.methods.Entryption;
import com.safewind.model.User;
import com.safewind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhh on 2018/6/2.
 */
@Service
public class UserServiceImpl implements UserService{
@Autowired
private UserDao userDao;

    @Override
    public boolean recheck(String realName) {
        User user=userDao.selectByRealName(realName);
        if(null==user)
            return true;
        return false;
    }

    @Override
    public User longin(String username, String password, String prefix) {//password为前台发过来加密的密码,entire为后台加密的密码
        User user=userDao.selectByRealName(username);
        Entryption entryption=new Entryption();
        String entire= entryption.md5prefix(prefix,user.getPassword());
        if(entire.equals(password))
           return user;
        return null;
    }

    @Override
    public boolean register(User user) {
        userDao.insert(user);
        return true;
    }
}
