package com.dwi.wilayah.services;

import com.dwi.wilayah.models.db.District;
import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.utilities.Constants;
import com.dwi.wilayah.utilities.ObjectMapperUtils;
import com.dwi.wilayah.repositories.DistrictRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//created By Dwi Sutrisno - Maret 2021

@Service
@Slf4j
public class DistrictService {

    final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public GeneralResponse getByRegencyId(String regencyId) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            generalResponse.setResponseCode(Constants.SUCCESS_CODE);
            generalResponse.setResponseMessage(Constants.SUCCESS_MESSAGE);
            generalResponse.setResponseContent(districtRepository.findByRegencyId(regencyId));
        } catch (Exception e) {
            e.printStackTrace();
            generalResponse.setResponseCode(Constants.ERROR_CODE);
            generalResponse.setResponseMessage(Constants.ERROR_MESSAGE);
        }
        log.info("GetByRegencyId Request : " + regencyId);
        log.info("GetByRegencyId Response : " + ObjectMapperUtils.toJson(generalResponse));
        return generalResponse;
    }

    public Page<District> getAllDistrict(String name, Integer page, Integer size) {
        return districtRepository.searchAllByName(name, PageRequest.of(page, size));
    }


}
