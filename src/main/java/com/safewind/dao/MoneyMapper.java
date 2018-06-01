package com.safewind.dao;

import com.safewind.model.Money;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Money record);

    int insertSelective(Money record);

    Money selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);
}