package com.bank.loans.service;


import com.bank.loans.dto.LoansDto;
import org.springframework.transaction.annotation.Transactional;

public interface ILoansService {

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Transactional
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber - Input mobile Number
     * @return Loan Details based on a given mobileNumber
     */
    @Transactional
    LoansDto fetchLoan(String mobileNumber);

    /**
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Transactional
    boolean updateLoan(LoansDto loansDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    @Transactional
    boolean deleteLoan(String mobileNumber);

}
