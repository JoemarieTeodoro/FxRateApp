package com.rate.fx.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 */
@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FxRateApiResponse {

    private Boolean success;
    private Query query;
    private Info info;
    private BigDecimal result;
    private Map<String, String> symbols;

}
