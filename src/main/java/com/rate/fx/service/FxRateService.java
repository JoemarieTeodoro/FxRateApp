package com.rate.fx.service;

import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.exception.FxRateConvertException;
import com.rate.fx.exception.FxRateListSymbolsException;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 * @description Base interface for processing FX rate transactions
 */
public interface FxRateService {

    /**
     * Retrieves the supported Fx symbols
     *
     * @return list of supported forex symbols
     * @throws FxRateListSymbolsException exception encountered while retrieving list of symbols
     */
    Set<String> listSymbols() throws FxRateListSymbolsException;

    /**
     * Convert rate value from one forex currency to another by specified value
     *
     * @param fromCurrency source currency
     * @param toCurrency destination currency
     * @param amount specified amount
     * @return object containing details of conversion
     * @throws FxRateConvertException exception encountered while conversion of rate
     */
    FxRateApiResponse convertRate(String fromCurrency, String toCurrency, BigDecimal amount) throws FxRateConvertException;
}
