package com.safewind.model;

import java.math.BigDecimal;

public class Money {
    private Integer id;

    private Integer userid;

    private BigDecimal remainsum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public BigDecimal getRemainsum() {
        return remainsum;
    }

    public void setRemainsum(BigDecimal remainsum) {
        this.remainsum = remainsum;
    }
}