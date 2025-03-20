package com.fissionx.lumi.configuration;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
@Component
public class GlobalRequestParam implements OperationCustomizer {
    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        Parameter customheader=new Parameter()
                .in(ParameterIn.HEADER.toString())
                .name("x-api-key")
                .description("please provide api key")
                .required(true)
                .example("your-valid-api-key")
                .schema(new StringSchema());
        operation.addParametersItem(customheader);
        return operation;
    }
}
