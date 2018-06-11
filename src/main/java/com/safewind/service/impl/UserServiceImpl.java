package com.safewind.service.impl;

import com.safewind.dao.UserDao;
import com.safewind.methods.Entryption;
import com.safewind.model.User;
import com.safewind.service.MoneyService;
import com.safewind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhh on 2018/6/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
@Autowired
private UserDao userDao;
@Autowired
private MoneyService moneyService;

    @Override
    public boolean recheck(String phoneNumber) {
        User user=userDao.selectByPhoneNumber(phoneNumber);
        if(null==user)
            return true;
        return false;
    }

    @Override
    public User longin(String username, String password, String prefix) {//password为前台发过来加密的密码,entire为后台加密的密码
        User user=userDao.selectByPhoneNumber(username);
        Entryption entryption=new Entryption();
        if(user==null){
            return null;
        }
        String entire= entryption.md5prefix(prefix,user.getPassword());
        if(entire.equals(password))
           return user;
        return null;
    }

    @Override
    public boolean register(User user) {
        Entryption entry = new Entryption();
        user.setPassword(entry.md5password(user.getPassword()));
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean recheckByNameAndTel(String phoneNumber, String realname) {
        User user=userDao.selectByPhoneNumber(phoneNumber);
        User user1=userDao.selectByRealName(realname);
        if(user.equals(user1))
            return true;
        return false;

    }

    @Override
    public User getUserMes(String tel) {
        User user=userDao.selectByPhoneNumber(tel);
        return user;
    }
}
