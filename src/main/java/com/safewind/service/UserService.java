package com.safewind.service;

import com.safewind.model.User;

/**
 * Created by qt on 2018/6/2.
 */
public interface UserService {
   boolean recheck(String realName);//判断此人有没有存在表中 0没有，可以插入，1已存在不可插入
   boolean longin(String username,String md5Pwd);
   boolean register(User user);
}
