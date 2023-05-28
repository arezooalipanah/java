package com.moneytransfer.converters;

import com.moneytransfer.core.BaseConverter;
import com.moneytransfer.dtos.TransactionDto;
import com.moneytransfer.models.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionConverter extends BaseConverter<Transaction, TransactionDto> {
}
