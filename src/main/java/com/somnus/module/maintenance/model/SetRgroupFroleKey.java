package com.somnus.module.maintenance.model;

import java.math.BigDecimal;

public class SetRgroupFroleKey {
    private BigDecimal rgroupId;

    private BigDecimal funcRoleId;

    public BigDecimal getRgroupId() {
        return rgroupId;
    }

    public void setRgroupId(BigDecimal rgroupId) {
        this.rgroupId = rgroupId;
    }

    public BigDecimal getFuncRoleId() {
        return funcRoleId;
    }

    public void setFuncRoleId(BigDecimal funcRoleId) {
        this.funcRoleId = funcRoleId;
    }
}