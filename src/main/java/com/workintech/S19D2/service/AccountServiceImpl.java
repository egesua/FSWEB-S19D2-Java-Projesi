package com.workintech.S19D2.service;

import com.workintech.S19D2.entity.Account;
import com.workintech.S19D2.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
