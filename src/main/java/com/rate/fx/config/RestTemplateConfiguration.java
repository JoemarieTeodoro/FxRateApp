package com.rate.fx.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 * @description Configuration class for Rest services.
 */
@AllArgsConstructor
@Configuration
public class RestTemplateConfiguration {

    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplateFXConvertRate() {
        return restTemplateBuilder.build();
    }

}
