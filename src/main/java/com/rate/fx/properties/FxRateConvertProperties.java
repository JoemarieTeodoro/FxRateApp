package com.rate.fx.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "fx-rates")
public class FxRateConvertProperties {

    private String baseUrl;
    private String accessKey;
    private String convertApi;
    private String symbolsApi;

}
