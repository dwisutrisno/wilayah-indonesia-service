package com.dwi.wilayah.controllers;

import com.dwi.wilayah.models.db.Regency;
import com.dwi.wilayah.utilities.Constants;
import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.services.RegencyService;
import com.dwi.wilayah.utilities.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//created By Dwi Sutrisno - Maret 2021

@RestController
@Slf4j
@RequestMapping("/api/v1/area/regency")
public class RegencyController {

    final RegencyService regencyService;

    public RegencyController(RegencyService regencyService) {
        this.regencyService = regencyService;
    }

    @GetMapping("/byProvinceId/{provinceId}")
//    @Cacheable(value = "regency", key = "#provinceId")
    public GeneralResponse getByProvinceId(@PathVariable String provinceId) {
        return regencyService.getByProvinceId(provinceId);
    }

    @GetMapping("")
    private GeneralResponse getAllRegency(@RequestParam Map<String, String> map) {

        Page<Regency> regencies = regencyService.getAllRegency(
                ObjectMapperUtils.strPassQueParam("search"),
                ObjectMapperUtils.intPassQueParam("page"),
                ObjectMapperUtils.intPassQueParam("size"));

        GeneralResponse generalResponse = new GeneralResponse();
        if (regencies.isEmpty()) {
            generalResponse.setResponseCode(Constants.ERROR_CODE);
            generalResponse.setResponseMessage(Constants.DATA_NOT_FOUND_MESSAGE);
        } else {
            generalResponse.setResponseCode(Constants.SUCCESS_CODE);
            generalResponse.setResponseMessage(Constants.SUCCESS_MESSAGE);
            generalResponse.setResponseContent(regencies);
        }
        log.info("GetAllRegency Request : " + ObjectMapperUtils.toJson(map));
        log.info("GetAllRegency Response : " + ObjectMapperUtils.toJson(generalResponse));
        return generalResponse;
    }

}
