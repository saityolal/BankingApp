package com.bank.cards.service;


import com.bank.cards.dto.CardsDto;
import org.springframework.transaction.annotation.Transactional;

public interface ICardsService {

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Transactional
    void createCard(String mobileNumber);

    /**
     * @param mobileNumber - Input mobile Number
     * @return Card Details based on a given mobileNumber
     */
    @Transactional
    CardsDto fetchCard(String mobileNumber);

    /**
     * @param cardsDto - CardsDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Transactional
    boolean updateCard(CardsDto cardsDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Transactional
    boolean deleteCard(String mobileNumber);

}
