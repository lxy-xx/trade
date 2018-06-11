package com.safewind.service;

import com.safewind.model.User;
import org.springframework.ui.Model;

/**
 * Created by qt on 2018/6/2.
 */
public interface UserService {
   boolean recheck(String realName);//判断此人有没有存在表中 0没有，可以插入，1已存在不可插入
   User longin(String username, String password, String  prefix);
   boolean register(User user);
   boolean recheckByNameAndTel(String phoneNumber,String realname);
   User getUserMes(String Tel);
}
