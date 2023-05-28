package com.moneytransfer.dtos;

import com.moneytransfer.core.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto extends AbstractDto {
    private String name;
    private Date openDate;
    private Date closeDate;
    private BigDecimal balance;
}
