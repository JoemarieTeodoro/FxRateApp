package com.rate.fx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import java.util.Date;

/**
 * @author Joemarie Teodoro
 * @since May 2021
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Response{

    private Integer responseCode;

    private String message;

    private String timestamp;

    private Object data;

    public Response(int code, String message) {
        this.responseCode = code;
        this.message = message;
        this.timestamp = new Date().toString();
    }

    public Response(int code, String message, Object data) {
        this.responseCode = code;
        this.message = message;
        this.timestamp = new Date().toString();
        this.data = data;
    }

}
