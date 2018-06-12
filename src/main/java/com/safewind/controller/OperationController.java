package com.safewind.controller;

import com.safewind.model.Money;
import com.safewind.model.Operation;
import com.safewind.model.User;
import com.safewind.service.MoneyService;
import com.safewind.service.OperationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by qt on 2018/6/11.
 */
@Controller
public class OperationController {
    @Autowired
    MoneyService moneyService;
    @Autowired
    OperationService operationService;
    @RequestMapping("getOperationMse")
    @ResponseBody
    public List<Operation> getOprations( HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        Money money=moneyService.getMoneyNow(user.getId());
        return operationService.selectOperation(money.getId());//根据session得到所有的操作记录
    }
}
