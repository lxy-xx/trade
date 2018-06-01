package com.safewind.dao;


import com.safewind.model.money;

public interface moneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(money record);

    int insertSelective(money record);

    money selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(money record);

    int updateByPrimaryKey(money record);
}