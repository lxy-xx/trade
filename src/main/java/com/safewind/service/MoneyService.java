package com.safewind.service;

import com.safewind.model.Money;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Created by qt on 2018/6/2.
 */
public interface MoneyService {
    String saveMoney(BigDecimal moneyNow,Integer userId);//存，取，得到
    String transferMoney(BigDecimal money, Integer userId, Integer toId);
    Money getMoneyNow(Integer UserId);
    String getInterestRates();
    boolean initMoney(Integer UserId);
}
