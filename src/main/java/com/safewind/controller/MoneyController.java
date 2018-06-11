package com.safewind.controller;

import com.safewind.dao.UserDao;
import com.safewind.model.Money;
import com.safewind.model.Operation;
import com.safewind.model.User;
import com.safewind.service.MoneyService;
import com.safewind.service.OperationService;
import com.safewind.service.UserService;
import com.safewind.service.impl.MoneyServiceImpl;
import com.safewind.service.impl.OperationServiceImpl;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by qt on 2018/6/2.
 */
@Controller

public class MoneyController {
    @Autowired
    private MoneyService moneyService ;
    @Autowired
    private UserService userService ;
    @RequestMapping("saveMoney")
    @ResponseBody
    public String saveMoney(@Param("money") BigDecimal money,@Param("userId") Integer userId){
       return moneyService.saveMoney(money,userId);
    }


    @RequestMapping("transferMoney")
    @ResponseBody
    public String transferMoney(@Param("money")BigDecimal money,@Param("toRealName")String toRealName,@Param("toId")String toId,HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        //User是当前用户，要传进来的真实姓名和账号匹配才可以转账。
        boolean result = true;
        if (!userService.recheckByNameAndTel(toRealName,toId))
            result=false;
       //return moneyService.transferMoney(money,userId,toId);
       //转多少，谁，给谁。

        if (result){
            //成功
            User user1=new User();
            user1=userService.getUserMes(toId);
            moneyService.transferMoney(money,user.getId(),user1.getId());
            return "{\"msg\":\"1\"}";
        }else {
            //失败
            return "{\"msg\":\"-1\"}";
        }


    }

    @RequestMapping("transfer")
    public String transfer(HttpSession session,Model model){
        User user = (User) session.getAttribute("currentUser");
        Money money = moneyService.getMoneyNow(user.getId());
        model.addAttribute("money",money);
        return "transfer";
    }

}
