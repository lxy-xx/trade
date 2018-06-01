package com.safewind.model;

import java.math.BigDecimal;

public class Operation {
    private Integer id;

    private Integer remainSumId;

    private Integer operationType;

    private Integer toWhoId;

    private BigDecimal transferAccounts;

    private BigDecimal saveMoney;

    private BigDecimal drawMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRemainSumId() {
        return remainSumId;
    }

    public void setRemainSumId(Integer remainSumId) {
        this.remainSumId = remainSumId;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Integer getToWhoId() {
        return toWhoId;
    }

    public void setToWhoId(Integer toWhoId) {
        this.toWhoId = toWhoId;
    }

    public BigDecimal getTransferAccounts() {
        return transferAccounts;
    }

    public void setTransferAccounts(BigDecimal transferAccounts) {
        this.transferAccounts = transferAccounts;
    }

    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    public BigDecimal getDrawMoney() {
        return drawMoney;
    }

    public void setDrawMoney(BigDecimal drawMoney) {
        this.drawMoney = drawMoney;
    }
}