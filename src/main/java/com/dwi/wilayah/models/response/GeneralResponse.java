package com.dwi.wilayah.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

//created by Dwi Sutrisno - Maret 2021

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse implements Serializable {
    private String responseCode;
    private String responseMessage;
    private String time;
    private String authToken;
    private Object responseContent;
    private Object listErrorMessage;
}