package com.workintech.S19D2.service;

import com.workintech.S19D2.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();
    Account save(Account account);
}
