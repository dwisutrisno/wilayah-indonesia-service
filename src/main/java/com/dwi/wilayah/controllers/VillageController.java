package com.dwi.wilayah.controllers;

//created By Dwi Sutrisno - Maret 2021

import com.dwi.wilayah.models.db.Village;
import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.services.VillageService;
import com.dwi.wilayah.utilities.Constants;
import com.dwi.wilayah.utilities.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/v1/area/village")
public class VillageController {

    final VillageService villageService;

    public VillageController(VillageService villageService) {
        this.villageService = villageService;
    }

    @GetMapping("/byDistrictId/{districtId}")
//    @Cacheable(value = "village", key = "#districtId")
    public GeneralResponse getByDistrictId(@PathVariable String districtId) {
        return villageService.getByDistrictId(districtId);
    }

    @GetMapping("")
    private GeneralResponse getAllVillage(@RequestParam Map<String, String> map) {
        Page<Village> regencies = villageService.getAllVillage(
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
        log.info("GetallVillage Request : " + ObjectMapperUtils.toJson(map));
        log.info("GetAllVillage Response : " + ObjectMapperUtils.toJson(generalResponse));
        return generalResponse;
    }
}
