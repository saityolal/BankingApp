package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountsService {
    /**
     * Creates a new account for the given customer
     *
     * @param customerDto the customer information
     */
    @Transactional
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - Input mobile number
     * @return Account details based on mobile number
     */
    @Transactional
    CustomerDto fetchAccount(String mobileNumber);

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating update status
     */
    @Transactional
    boolean updateAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber -Delete account based on mobile number
     * @return boolean indicating delete status
     */
    @Transactional
    boolean deleteAccount(String mobileNumber);
}
