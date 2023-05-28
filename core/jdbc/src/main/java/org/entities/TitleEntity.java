package org.entities;

import java.sql.Date;

public class TitleEntity {

    private Integer WORKER_REF_ID;

    private String WORKER_TITLE;

    private Date AFFECTED_FROM;

    private int AGGREGATE;

    public Integer getWORKER_REF_ID() {
        return WORKER_REF_ID;
    }

    public void setWORKER_REF_ID(Integer WORKER_REF_ID) {
        this.WORKER_REF_ID = WORKER_REF_ID;
    }

    public String getWORKER_TITLE() {
        return WORKER_TITLE;
    }

    public void setWORKER_TITLE(String WORKER_TITLE) {
        this.WORKER_TITLE = WORKER_TITLE;
    }

    public Date getAFFECTED_FROM() {
        return AFFECTED_FROM;
    }

    public void setAFFECTED_FROM(Date AFFECTED_FROM) {
        this.AFFECTED_FROM = AFFECTED_FROM;
    }

    public int getAGGREGATE() {
        return AGGREGATE;
    }

    public void setAGGREGATE(int AGGREGATE) {
        this.AGGREGATE = AGGREGATE;
    }

    @Override
    public String toString() {
        return "TitleEntity{" +
                "WORKER_REF_ID=" + WORKER_REF_ID +
                ", WORKER_TITLE='" + WORKER_TITLE + '\'' +
                ", AFFECTED_FROM=" + AFFECTED_FROM +
                ", AGGREGATE=" + AGGREGATE +
                '}';
    }
}
