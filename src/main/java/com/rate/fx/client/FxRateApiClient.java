package com.rate.fx.client;

import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.exception.FxRateConvertException;
import com.rate.fx.exception.FxRateListSymbolsException;
import com.rate.fx.properties.FxRateConvertProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 * @description Class that handle service request to FX rate Api
 */
@Slf4j
@Component
public class FxRateApiClient {

    private RestTemplate restTemplate;

    private FxRateConvertProperties fxRateConvertProperties;

    public FxRateApiClient(RestTemplate restTemplateFXConvertRate, FxRateConvertProperties fxRateConvertProperties) {
        this.restTemplate = restTemplateFXConvertRate;
        this.fxRateConvertProperties = fxRateConvertProperties;
    }

    public FxRateApiResponse convertRate(String fromCurrency, String toCurrency, BigDecimal amount) throws FxRateConvertException {

        try {
            final FxRateApiResponse fxRateApiResponse =
                    restTemplate.getForObject(createConvertUri(fromCurrency, toCurrency, amount), FxRateApiResponse.class);

            if (fxRateApiResponse == null) {
                throw new FxRateConvertException("Unable to convert rates!.");
            }
            log.info("Fx rates successfully converted.");
            return fxRateApiResponse;

        } catch (RestClientException e) {
            throw new FxRateConvertException(String.format("Error occurred while converting rates!. Message [%s].", e.getMessage()));
        }

    }

    public FxRateApiResponse listSymbols() throws FxRateListSymbolsException {
        try {
            final FxRateApiResponse fxRateApiResponse =
                    restTemplate.getForObject(createSymbolUri(), FxRateApiResponse.class);

            if (fxRateApiResponse == null) {
                throw new FxRateListSymbolsException("Unable to retrieved list of symbols!.");
            }
            log.info("Fx symbols successfully retrieved.");
            return fxRateApiResponse;

        } catch (RestClientException e) {
            throw new FxRateListSymbolsException("Error occurred while retrieving symbols!.");
        }
    }

    private String createConvertUri(String fromCurrency, String toCurrency, BigDecimal amount) {
        final String convertUri = String.format(fxRateConvertProperties.getConvertApi(), fxRateConvertProperties.getAccessKey(),
                fromCurrency, toCurrency, amount);
        return fxRateConvertProperties.getBaseUrl().concat(convertUri);
    }

    private String createSymbolUri() {
        final String symbolsApi = String.format(fxRateConvertProperties.getSymbolsApi(), fxRateConvertProperties.getAccessKey());
        return fxRateConvertProperties.getBaseUrl().concat(symbolsApi);
    }

}
