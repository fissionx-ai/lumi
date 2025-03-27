package com.fissionx.lumi.configuration;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.util.Collections;

@Component
public class GlobalRequestParam implements OperationCustomizer {

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        Server server = new Server();
        server.setUrl("https://fissionx-forms.fly.dev");
        server.setDescription("FissionX Form Dev Server");

        operation.setServers(Collections.singletonList(server));

        Parameter customHeader = new Parameter()
                .in(ParameterIn.HEADER.toString())
                .name("x-api-key")
                .description("please provide api key")
                .required(true)
                .example("your-valid-api-key")
                .schema(new StringSchema());

        operation.addParametersItem(customHeader);

        return operation;
    }
}