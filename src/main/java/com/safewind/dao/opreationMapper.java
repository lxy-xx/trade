package com.safewind.dao;


import com.safewind.model.opreation;

public interface opreationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(opreation record);

    int insertSelective(opreation record);

    opreation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(opreation record);

    int updateByPrimaryKey(opreation record);
}