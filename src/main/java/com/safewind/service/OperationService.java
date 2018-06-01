package com.safewind.service;

import com.safewind.model.Operation;

/**
 * Created by qt on 2018/6/2.
 */
public interface OperationService {
    int insertOperation(Operation operation);
    int deleteOperation(Integer id);
    Operation selectOperation(Integer remainSumId);//得到一个用户最近的一条操作记录

}
