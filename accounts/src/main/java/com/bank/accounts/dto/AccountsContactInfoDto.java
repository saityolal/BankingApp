package com.bank.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountsContactInfoDto {
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