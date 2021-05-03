package com.rate.fx.constant;

import com.rate.fx.dto.FxRateApiResponse;
import com.rate.fx.dto.Info;
import com.rate.fx.dto.Query;
import org.mockito.internal.util.collections.Sets;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Joemarie Teodoro
 * @since April 2021
 * @description Class containing constants for unit test cases
 */
public final class FxRateTestConstant {

    public static Set<String> createSymbols() {
        return Sets.newSet("USD", "INR");
    }

    public static FxRateApiResponse createFxApiResponse() {

        FxRateApiResponse fxRateApiResponse = new FxRateApiResponse();
        fxRateApiResponse.setSuccess(true);

        Query query = new Query();
        query.setFrom("GBP");
        query.setTo("JPY");
        query.setAmount(BigDecimal.valueOf(25));
        fxRateApiResponse.setQuery(query);

        Info info = new Info();
        info.setRate(new BigDecimal(148.972231));
        fxRateApiResponse.setInfo(info);

        fxRateApiResponse.setResult(BigDecimal.valueOf(3724.305775));
        Map symbols = new HashMap();
        symbols.put("USD", "United States Dollar");
        symbols.put("EUR", "Euro");
        symbols.put("JPY", "Japanese Yen");
        symbols.put("INR", "Indian Rupee");

        fxRateApiResponse.setSymbols(symbols);
        return fxRateApiResponse;
    }

}
