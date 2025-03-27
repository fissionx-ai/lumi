package com.fissionx.lumi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

import static java.util.List.of;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();
        server.setUrl("https://fissionx-forms.fly.dev");
        server.setDescription("FissionX Form Dev Server");

        Parameter customHeader = new Parameter()
                .in("header")
                .name("x-api-key")
                .description("please provide api key")
                .required(true)
                .example("your-valid-api-key")
                .schema(new StringSchema());

        return new OpenAPI()
                .servers(of(server))
                .components(new Components()
                        .addParameters("x-api-key", customHeader));
    }
}