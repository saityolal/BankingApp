package com.bank.loans;

import com.bank.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
@EnableConfigurationProperties(value = {
        LoansContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Loans Microservice REST API Documentation",
                description = "Loans of Sait Microservice REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Sait",
                        email = "msaityolal@gmail.com",
                        url = "https://github.com/saityolal"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )

        ))
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
