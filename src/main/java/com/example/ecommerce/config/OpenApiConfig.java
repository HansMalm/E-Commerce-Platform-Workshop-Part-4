package com.example.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for SpringDoc OpenAPI / Swagger UI.
 *
 * <p>Javadoc comments on controllers and DTOs are surfaced in the
 * Swagger UI automatically via the Therapi Runtime Javadoc library
 * (compiled into the JAR by {@code therapi-runtime-javadoc-scribe}).</p>
 */
@Configuration
public class OpenApiConfig {

    /**
     * Defines the top-level metadata shown in the Swagger UI header.
     *
     * @return fully configured {@link OpenAPI} instance
     */
    @Bean
    public OpenAPI ecommerceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce Platform API")
                        .description(
                                "RESTful API for the E-Commerce Platform. " +
                                "Browse and test all available endpoints below.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("E-Commerce Team")
                                .email("team@ecommerce.example.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
