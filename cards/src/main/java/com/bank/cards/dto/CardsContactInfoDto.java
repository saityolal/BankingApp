package com.bank.cards.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDto(String message, ContactDetails contactDetails ) {
}
record ContactDetails(String name, String email, String github) {}