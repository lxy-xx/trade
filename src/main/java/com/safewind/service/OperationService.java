package com.safewind.service;

import com.safewind.model.Operation;

import java.util.List;

/**
 * Created by qt on 2018/6/2.
 */
public interface OperationService {
    int insertOperation(Operation operation);
    int deleteOperation(Integer id);
    List<Operation> selectOperation(Integer remainSumId);//得到一个用户所有操作记录

}
