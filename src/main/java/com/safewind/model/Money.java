package com.safewind.model;

import java.math.BigDecimal;

public class Money {
    private Integer id;

    private Integer userId;

    private BigDecimal remainSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getRemainSum() {
        return remainSum;
    }

    public void setRemainSum(BigDecimal remainSum) {
        this.remainSum = remainSum;
    }
}