package com.bank.accounts.controller;

import com.bank.accounts.constants.AccountConstants;
import com.bank.accounts.dto.AccountsContactInfoDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.dto.ErrorResponseDto;
import com.bank.accounts.dto.ResponseDto;
import com.bank.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs fo Accounts",
        description = "CRUD REST APIs in Microservice to CREATE, FETCH, UPDATE and DELETE account details")
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {

    private final IAccountsService iAccountsService;

    @Autowired
    public AccountsController(IAccountsService iAccountsService) {
        this.iAccountsService = iAccountsService;
    }

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;

    @Value("${build.version}")
    private String buildVersion;

    @Operation(summary = "Create a new account REST API",
            description = "Create a new account REST API in Microservice to CREATE a new account")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )

    })
    @PostMapping("/create-account")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(summary = "Fetch account details REST API",
            description = "REST API to fetch account and customer details based on mobile number")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )

    })
    @GetMapping("/fetch-account")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {
        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(summary = "Update account details REST API",
            description = "REST API to update account and customer details based on mobile number")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )

    })

    @PutMapping("/update-account")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(summary = "Delete account and customer details REST API",
            description = "REST API to delete account and customer details based on mobile number")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )

    })
    @DeleteMapping("/delete-account")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber) {
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(summary = "Get version of the Application",
            description = "REST API to get version of the Application")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )

    })
    @GetMapping("/version")
    public ResponseEntity<String> getVersion() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(buildVersion);
    }


    @Operation(summary = "Get Java version",
            description = "Get Java version details that is installed into accounts microservice")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )

    })
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @Operation(summary = "Get contact info",
            description = "Get contact info of account microservice")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDto);
    }
}