package com.rate.fx.dto;

import lombok.Data;

/**
 * @author Joemarie Teodoro
 * * @since May 2021
 */
@Data
public class ErrorResponse {

    private Integer responseCode;
    private String message;
    private String timeStamp;

}
