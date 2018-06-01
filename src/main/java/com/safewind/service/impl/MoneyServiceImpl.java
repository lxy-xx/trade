package com.safewind.service.impl;

import com.safewind.dao.MoneyMapper;
import com.safewind.model.Money;
import com.safewind.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qt on 2018/6/2.
 */
@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyMapper moneyMapper;
    @Override
    public int saveMoney(Money moneyNow) {
        return moneyMapper.updateByPrimaryKey(moneyNow);
    }

    @Override
    public int drawMoney(Money moneyNow) {
        return moneyMapper.updateByPrimaryKey(moneyNow);
    }

    @Override
    public Money getMoneyNow(Integer UserId) {
        return moneyMapper.selectByPrimaryKey(UserId);
    }

}
