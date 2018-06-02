package com.safewind.controller;

import com.safewind.model.Money;
import com.safewind.model.Operation;
import com.safewind.service.MoneyService;
import com.safewind.service.OperationService;
import com.safewind.service.impl.MoneyServiceImpl;
import com.safewind.service.impl.OperationServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by qt on 2018/6/2.
 */
@Controller

public class MoneyController {
    @Autowired
    private MoneyService moneyService ;
    @Autowired
    private OperationService operationService;
    @RequestMapping("saveMoney")
    @ResponseBody
    public String saveMoney(@Param("money") BigDecimal money,@Param("userId") Integer userId){
       return moneyService.saveMoney(money,userId);
    }
    @RequestMapping("transferMoney")
    @ResponseBody
    public String transferMoney(@Param("money")BigDecimal money,@Param("userId")Integer userId,@Param("toId")Integer toId){
       return moneyService.transferMoney(money,userId,toId);
       //转多少，谁，给谁。
    }
}
