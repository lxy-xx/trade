package com.safewind.service.impl;

import com.safewind.dao.OperationMapper;
import com.safewind.model.Money;
import com.safewind.model.Operation;
import com.safewind.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qt on 2018/6/2.
 */
@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationMapper operationMapper;
    @Override
    public int insertOperation(Operation operation) {
        return operationMapper.insert(operation);
    }

    @Override
    public int deleteOperation(Integer id) {
        return operationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Operation selectOperation(Integer remainSumId) {
       // Money money=new User
        return operationMapper.selectByPrimaryKey(remainSumId);
    }
}
