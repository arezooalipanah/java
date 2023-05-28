package org.entities;

import java.sql.Date;

public class WorkerEntity {
    private Integer WORKER_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private Integer SALARY;
    private Date JOINING_DATE;
    private String DEPARTMENT;

    private int AGGREGATE;

    public Integer getWORKER_ID() {
        return WORKER_ID;
    }

    public void setWORKER_ID(Integer WORKER_ID) {
        this.WORKER_ID = WORKER_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public Integer getSALARY() {
        return SALARY;
    }

    public void setSALARY(Integer SALARY) {
        this.SALARY = SALARY;
    }

    public Date getJOINING_DATE() {
        return JOINING_DATE;
    }

    public void setJOINING_DATE(Date JOINING_DATE) {
        this.JOINING_DATE = JOINING_DATE;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public int getAGGREGATE() {
        return AGGREGATE;
    }

    public void setAGGREGATE(int AGGREGATE) {
        this.AGGREGATE = AGGREGATE;
    }

    @Override
    public String toString() {
        return "WorkerEntity{" +
                "WORKER_ID=" + WORKER_ID +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", AGGREGATE='" + AGGREGATE + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", SALARY=" + SALARY +
                ", JOINING_DATE=" + JOINING_DATE +
                ", DEPARTMENT='" + DEPARTMENT + '\'' +
                '}';
    }
}
