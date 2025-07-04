package com.bank.cards.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cards")
@Getter
@Setter
public class CardsContactInfoDto {
    private String message;
    private ContactDetails contactDetails;
}

@Setter
@Getter
class ContactDetails {
    private String name;
    private String email;
    private String github;
}