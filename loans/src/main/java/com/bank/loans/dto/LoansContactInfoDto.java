package com.bank.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "loans")
public record LoansContactInfoDto(String message, ContactDetails contactDetails) {
    public record ContactDetails(String name, String email, String github) {}
}