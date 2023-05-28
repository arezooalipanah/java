package com.moneytransfer.core;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractDto {
    private Long id;
    private Long version;
    private Date insertTimestamp;
    private Date lastUpdateTimestamp;
}
