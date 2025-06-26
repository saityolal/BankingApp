package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "ErrorResponse",
        description = "Schema to represent Error Response information")
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by the client")
    private String apiPath;

    @Schema(
            description = "Error code of the response")
    private HttpStatus errorCode;

    @Schema(
            description = "Error message in the response")
    private String errorMessage;

    @Schema(
            description = "Time when the error occurred")
    private LocalDateTime errorTime;

}
