package com.rate.fx.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 */
@Slf4j
@Data
public class Query {

    private String from;
    private String to;
    private BigDecimal amount;

}
