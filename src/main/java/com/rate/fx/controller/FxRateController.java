package com.rate.fx.controller;

import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.exception.FxRateConvertException;
import com.rate.fx.exception.FxRateListSymbolsException;
import com.rate.fx.service.FxRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 * @description Request entry point for FX rate transactions
 */
@RequestMapping("/app/v1")
@RestController
public class FxRateController {

    private FxRateService fxRateService;

    public FxRateController(FxRateService fxRateService) {
        this.fxRateService = fxRateService;
    }

    @Operation(summary = "Get all supported FX symbols", tags = "fx supported symbols")
    @GetMapping(value = "/symbols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<String>> listSymbols() throws FxRateListSymbolsException {
        return new ResponseEntity<>(fxRateService.listSymbols(), HttpStatus.OK);
    }

    @Operation(summary = "Convert value from one FX symbol to another symbol", tags = "convert fx rates")
    @GetMapping(value = "/convert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FxRateApiResponse> convertRate(
            @Parameter(description = "source fx symbol", example = "USD") @RequestParam String fromCurrency,
            @Parameter(description = "destination fx symbol", example = "INR") @RequestParam String toCurrency,
            @Parameter(description = "amount value", example = "1") @RequestParam BigDecimal amount) throws FxRateConvertException {
        return new ResponseEntity<>(fxRateService.convertRate(fromCurrency, toCurrency, amount), HttpStatus.OK);
    }

}
