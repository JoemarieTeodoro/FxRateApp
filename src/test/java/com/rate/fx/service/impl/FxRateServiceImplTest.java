package com.rate.fx.service.impl;

import com.rate.fx.client.FxRateApiClient;
import com.rate.fx.constant.FxRateTestConstant;
import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.exception.FxRateConvertException;
import com.rate.fx.exception.FxRateListSymbolsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Joemarie Teodoro
 * @since April 2021
 */
@RunWith(MockitoJUnitRunner.class)
public class FxRateServiceImplTest {

    @InjectMocks
    private FxRateServiceImpl fxRateServiceImpl;

    @Mock
    private FxRateApiClient fxRateApiClient;

    @Test
    public void testListSymbols() throws FxRateListSymbolsException {
        when(fxRateApiClient.listSymbols()).thenReturn(FxRateTestConstant.createFxApiResponse());
        final Set<String> symbols = fxRateServiceImpl.listSymbols();

        assertTrue(symbols.contains("USD"));
        assertFalse(symbols.isEmpty());
    }

    @Test
    public void testConvertRate() throws FxRateConvertException {
        when(fxRateApiClient.convertRate(anyString(), anyString(), any(BigDecimal.class))).thenReturn(FxRateTestConstant.createFxApiResponse());
        final BigDecimal amountToConvert = BigDecimal.valueOf(25);
        final FxRateApiResponse fxRateApiResponse =
                fxRateServiceImpl.convertRate("GBP", "JPY", amountToConvert);

        assertNotNull(fxRateApiResponse);
        assertNotNull(fxRateApiResponse.getInfo());
        final BigDecimal conversion = fxRateApiResponse.getInfo().getRate().multiply(amountToConvert).setScale(6, BigDecimal.ROUND_UP);
        assertEquals(conversion, fxRateApiResponse.getResult());
    }

}