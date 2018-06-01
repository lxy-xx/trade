package com.safewind.model;

import java.math.BigDecimal;

public class Opreation {
    private Integer id;

    private Integer remainsumid;

    private Integer oprationtype;

    private Integer towhoid;

    private BigDecimal transferaccounts;

    private BigDecimal savemoney;

    private BigDecimal drawmoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRemainsumid() {
        return remainsumid;
    }

    public void setRemainsumid(Integer remainsumid) {
        this.remainsumid = remainsumid;
    }

    public Integer getOprationtype() {
        return oprationtype;
    }

    public void setOprationtype(Integer oprationtype) {
        this.oprationtype = oprationtype;
    }

    public Integer getTowhoid() {
        return towhoid;
    }

    public void setTowhoid(Integer towhoid) {
        this.towhoid = towhoid;
    }

    public BigDecimal getTransferaccounts() {
        return transferaccounts;
    }

    public void setTransferaccounts(BigDecimal transferaccounts) {
        this.transferaccounts = transferaccounts;
    }

    public BigDecimal getSavemoney() {
        return savemoney;
    }

    public void setSavemoney(BigDecimal savemoney) {
        this.savemoney = savemoney;
    }

    public BigDecimal getDrawmoney() {
        return drawmoney;
    }

    public void setDrawmoney(BigDecimal drawmoney) {
        this.drawmoney = drawmoney;
    }
}