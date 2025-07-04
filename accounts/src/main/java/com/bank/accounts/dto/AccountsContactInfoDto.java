package com.bank.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountsContactInfoDto(String message, ContactDetails contactDetails ) {
}
record ContactDetails(String name, String email, String github) {}