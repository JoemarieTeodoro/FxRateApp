package com.rate.fx.controller;

import com.rate.fx.constant.FxRateTestConstant;
import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.exception.FxRateConvertException;
import com.rate.fx.exception.FxRateListSymbolsException;
import com.rate.fx.service.FxRateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.Set;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Joemarie Teodoro
 * @since April 2021
 */
@RunWith(MockitoJUnitRunner.class)
public class FxRateControllerTest {

    @InjectMocks
    private FxRateController fxRateController;

    @Mock
    private FxRateService fxRateService;

    @Test
    public void testListSymbols() throws FxRateListSymbolsException {
        when(fxRateService.listSymbols()).thenReturn(FxRateTestConstant.createSymbols());
        final ResponseEntity<Set<String>> response = fxRateController.listSymbols();

        final Set<String> symbols = response.getBody();
        assertNotNull(symbols);
        assertTrue(symbols.contains("USD"));
        assertTrue(symbols.contains("INR"));
        assertFalse(symbols.contains("N/A"));
    }

    @Test
    public void testConvert() throws FxRateConvertException {
        when(fxRateService.convertRate(anyString(), anyString(), any(BigDecimal.class))).thenReturn(FxRateTestConstant.createFxApiResponse());

        final ResponseEntity<FxRateApiResponse> response =
                fxRateController.convertRate("USD", "INR", BigDecimal.valueOf(1000.20));

        assertNotNull(response.getBody());
    }

}