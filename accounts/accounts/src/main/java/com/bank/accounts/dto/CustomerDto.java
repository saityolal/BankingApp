package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer",
        description = "Schema to represent Customer and Account details")
public class CustomerDto {

    @Schema(
            description = "Name of the Customer", example = "Sait Yolal")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    @Schema(
            description = "Email of the Customer", example = "msaityolal@gmail.com")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format please enter a valid email address")
    private String email;

    @Schema(
            description = "Mobile number of the Customer", example = "15566067112")
    @Pattern(regexp = "(^[0-9]{9,11})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer")
    private AccountsDto accountsDto;
}
