package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * Creates a new account for the given customer
     * @param customerDto the customer information
     */
    void createAccount(CustomerDto customerDto);
}
