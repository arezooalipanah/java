package com.moneytransfer.repositories;

import com.moneytransfer.core.BaseRepository;
import com.moneytransfer.models.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
}
