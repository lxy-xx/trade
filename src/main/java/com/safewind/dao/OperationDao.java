package com.safewind.dao;

import com.safewind.model.Operation;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}