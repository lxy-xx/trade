package com.safewind.dao;

import com.safewind.model.Money;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MoneyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Money record);

    int insertSelective(Money record);

    Money selectByPrimaryKey(Integer id);

    BigDecimal getRemainByUserId(Integer userId);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);

    BigDecimal getInterestRates();
}