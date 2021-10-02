package com.dwi.wilayah.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

//created By Dwi S - Oktober 2021

public final class ObjectMapperUtils {

    public static String toJson(Object objParam) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result;
        try {
            result = objectMapper.writeValueAsString(objParam);
        } catch (Exception e) {
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    //convert and check query param string to int
    public static Integer intPassQueParam(String value) {
        return value != null ? Integer.parseInt(value) : 10;
    }

    //convert and check query param string to string
    public static String strPassQueParam(String value) {
        return value != null ? value : "";
    }



}
