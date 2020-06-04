package com.buckzy.plaid.configuration;

import com.buckzy.core.web.exception.handler.RestExceptionHandlerHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    public RestExceptionHandlerHelper getRestExceptionHandlerHelper() {
        return new RestExceptionHandlerHelper();
    }
}
