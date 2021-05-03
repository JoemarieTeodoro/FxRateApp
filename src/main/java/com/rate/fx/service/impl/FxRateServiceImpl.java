package com.rate.fx.service.impl;

import com.rate.fx.client.FxRateApiClient;
import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.exception.FxRateConvertException;
import com.rate.fx.exception.FxRateListSymbolsException;
import com.rate.fx.service.FxRateService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 * @description Service class for FX rate transactions
 */
@Service
public class FxRateServiceImpl implements FxRateService {

    private FxRateApiClient fxRateApiClient;

    public FxRateServiceImpl(FxRateApiClient fxRateApiClient) {
        this.fxRateApiClient = fxRateApiClient;
    }

    @Override
    public Set<String> listSymbols() throws FxRateListSymbolsException {
        final FxRateApiResponse fxRateApiResponse = fxRateApiClient.listSymbols();
        return fxRateApiResponse.getSymbols().keySet();
    }

    @Override
    public FxRateApiResponse convertRate(String fromCurrency, String toCurrency, BigDecimal amount) throws FxRateConvertException {
        return fxRateApiClient.convertRate(fromCurrency, toCurrency, amount);
    }

}
