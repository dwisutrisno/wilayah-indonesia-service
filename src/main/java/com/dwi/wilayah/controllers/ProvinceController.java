package com.dwi.wilayah.controllers;

import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.services.ProvinceService;
import com.dwi.wilayah.utilities.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//created By Dwi Sutrisno - Maret 2021

@RestController
@Slf4j
@RequestMapping("/api/v1/area/province")
public class ProvinceController {

    final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("")
//    @Cacheable(value = "province")
    public GeneralResponse getAllProvince() {
        GeneralResponse generalResponse = provinceService.getAllProvince();
        log.info("GetAllProvince Response : " + ObjectMapperUtils.toJson(generalResponse));
        return generalResponse;
    }


}
