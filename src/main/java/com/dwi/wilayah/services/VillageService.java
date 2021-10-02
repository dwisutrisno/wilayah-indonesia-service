package com.dwi.wilayah.services;

import com.dwi.wilayah.models.db.Village;
import com.dwi.wilayah.utilities.Constants;
import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.repositories.VillageRepository;
import com.dwi.wilayah.utilities.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//created By Dwi Sutrisno - Maret 2021

@Service
@Slf4j
public class VillageService {

    final VillageRepository villageRepository;

    public VillageService(VillageRepository villageRepository) {
        this.villageRepository = villageRepository;
    }

    public GeneralResponse getByDistrictId(String districtId) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            generalResponse.setResponseCode(Constants.SUCCESS_CODE);
            generalResponse.setResponseMessage(Constants.SUCCESS_MESSAGE);
            generalResponse.setResponseContent(villageRepository.findByDistrictId(districtId));
        } catch (Exception e) {
            e.printStackTrace();
            generalResponse.setResponseCode(Constants.ERROR_CODE);
            generalResponse.setResponseCode(Constants.ERROR_MESSAGE);
        }
        log.info("GetByDistrictId Request : " + districtId);
        log.info("GetByDistrictId Response : " + ObjectMapperUtils.toJson(generalResponse));
        return generalResponse;
    }

    public Page<Village> getAllVillage(String name, Integer page, Integer size) {
        return villageRepository.searchAllByName(name, PageRequest.of(page, size));
    }

}
