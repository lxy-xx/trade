package com.safewind.service.impl;

import com.safewind.dao.MoneyDao;
import com.safewind.model.Money;
import com.safewind.model.Operation;
import com.safewind.service.MoneyService;
import com.safewind.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * Created by qt on 2018/6/2.
 */
@Service
@Transactional
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyDao moneyDao;
    @Autowired
    private OperationService operationService;
    @Override
    public String saveMoney(BigDecimal money,Integer userId) {
        Money moneyNow=this.getMoneyNow(userId);
        int remainSumId=moneyNow.getId();
        BigDecimal money2=moneyNow.getRemainSum();
        //当前余额
        Operation operation=new Operation();
        operation.setOperationType(0);//存钱
        operation.setRemainSumId(remainSumId);
        operation.setSaveMoney(money);

        Money money1=new Money();
        money1.setRemainSum(money.add(money2));
        money1.setUserId(userId);
        int c=operationService.insertOperation(operation);
        int b=moneyDao.updateByPrimaryKey(money1);
        if (c==1&&b==1)
            return "1";//成功
        else
            return "0";
    }

    @Override
    public String transferMoney(BigDecimal money, Integer userId, Integer toId) {

        Money moneyNow=this.getMoneyNow(userId);
        Money moneyTo=this.getMoneyNow(toId);
        int toRemainSumId=moneyTo.getId();
        int remainSumId=moneyNow.getId();

        BigDecimal money2=moneyNow.getRemainSum();
        BigDecimal money3=moneyTo.getRemainSum();
        Operation operation=new Operation();
        operation.setOperationType(1);//转账
        operation.setRemainSumId(remainSumId);
        operation.setToWhoId(toId);
        operation.setTransferAccounts(money);

        Operation operation2=new Operation();
        operation2.setOperationType(0);//存账
        operation2.setRemainSumId(toRemainSumId);
        operation2.setSaveMoney(money);

        Money money1=new Money();
        money1.setRemainSum(money2.subtract(money));
        money1.setUserId(userId);

        Money money4=new Money();
        money4.setRemainSum(money3.add(money));
        money4.setUserId(toId);
        if (operationService.insertOperation(operation)==1&&moneyDao.updateByPrimaryKey(money1)==1&&operationService.insertOperation(operation2)==1&&moneyDao.updateByPrimaryKey(money4)==1){
            return "1";

        }else
            return "0";
    }

    @Override
    public Money getMoneyNow(Integer UserId) {
        return moneyDao.selectByPrimaryKey(UserId);
    }

    @Override
    public String getInterestRates() {
        String rates = moneyDao.getInterestRates().toString();
        System.out.println(rates);
        return rates;
    }

}
