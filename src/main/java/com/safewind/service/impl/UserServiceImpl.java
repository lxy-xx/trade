package com.safewind.service.impl;

import com.safewind.dao.UserDao;
import com.safewind.methods.Entryption;
import com.safewind.methods.TimeSeed;
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
    public boolean longin(String realname,String md5Pwd) {//md5Pwd为前台发过来加密的密码,entire为后台加密的密码
        Entryption entryption=new Entryption();
        TimeSeed timeSeed = new TimeSeed();
        User user=userDao.selectByRealName(realname);
        String entirePwd=entryption.md5prefix(timeSeed.getPreviousTime(),user.getPassword());
        if(entirePwd.equals(md5Pwd))
            return true;
        return false;
    }

    @Override
    public boolean register(User user) {
        userDao.insert(user);
        return true;
    }
}
