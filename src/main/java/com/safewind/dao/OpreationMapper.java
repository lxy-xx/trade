package com.safewind.dao;


import com.safewind.model.Opreation;

public interface OpreationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Opreation record);

    int insertSelective(Opreation record);

    Opreation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Opreation record);

    int updateByPrimaryKey(Opreation record);
}