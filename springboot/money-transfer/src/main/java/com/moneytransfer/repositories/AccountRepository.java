package com.moneytransfer.repositories;

import com.moneytransfer.core.BaseRepository;
import com.moneytransfer.models.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
}
