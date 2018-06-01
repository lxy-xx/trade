package com.safewind.service;

import com.safewind.model.Money;

/**
 * Created by qt on 2018/6/2.
 */
public interface MoneyService {
    int saveMoney(Money moneyNow);//存，取，得到
    int drawMoney(Money moneyNow);
    Money getMoneyNow(Integer UserId);
}
