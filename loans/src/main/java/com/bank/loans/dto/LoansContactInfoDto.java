package com.bank.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "loans")
@Getter
@Setter
public class LoansContactInfoDto {
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