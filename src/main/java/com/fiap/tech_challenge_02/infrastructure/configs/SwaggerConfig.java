package com.fiap.tech_challenge_02.infrastructure.configs;

import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("add-user-id-header")
                .addOperationCustomizer((operation, $) -> {
                    operation.addParametersItem(
                            new HeaderParameter()
                                    .name("token")
                                    .description("Access Token")
                                    .required(false));
                    operation.addParametersItem(
                            new HeaderParameter()
                                    .name("client-id")
                                    .description("Usuário id")
                                    .required(false));
                    return operation;
                }).build();
    }
}