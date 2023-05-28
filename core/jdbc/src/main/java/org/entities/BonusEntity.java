package org.entities;

import java.sql.Date;

public class BonusEntity {
    private Integer WORKER_REF_ID;
    private Integer BONUS_AMOUNT;
    private Date BONUS_DATE;

    public Integer getWORKER_REF_ID() {
        return WORKER_REF_ID;
    }

    public void setWORKER_REF_ID(Integer WORKER_REF_ID) {
        this.WORKER_REF_ID = WORKER_REF_ID;
    }

    public Integer getBONUS_AMOUNT() {
        return BONUS_AMOUNT;
    }

    public void setBONUS_AMOUNT(Integer BONUS_AMOUNT) {
        this.BONUS_AMOUNT = BONUS_AMOUNT;
    }

    public Date getBONUS_DATE() {
        return BONUS_DATE;
    }

    public void setBONUS_DATE(Date BONUS_DATE) {
        this.BONUS_DATE = BONUS_DATE;
    }
}
