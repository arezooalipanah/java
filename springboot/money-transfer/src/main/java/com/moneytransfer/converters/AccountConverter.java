package com.moneytransfer.converters;

import com.moneytransfer.core.BaseConverter;
import com.moneytransfer.dtos.AccountDto;
import com.moneytransfer.models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountConverter extends BaseConverter<Account, AccountDto> {
}
