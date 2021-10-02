package com.dwi.wilayah.services;

import com.dwi.wilayah.models.db.Regency;
import com.dwi.wilayah.utilities.Constants;
import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.repositories.RegencyRepository;
import com.dwi.wilayah.utilities.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//created By Dwi Sutrisno - Maret 2021

@Service
@Slf4j
public class RegencyService {

    final RegencyRepository regencyRepository;

    public RegencyService(RegencyRepository regencyRepository) {
        this.regencyRepository = regencyRepository;
    }

    public GeneralResponse getByProvinceId(String provinceId) {

        GeneralResponse generalResponse = new GeneralResponse();
        try {
            generalResponse.setResponseCode(Constants.SUCCESS_CODE);
            generalResponse.setResponseMessage(Constants.SUCCESS_MESSAGE);
            generalResponse.setResponseContent(regencyRepository.findByProvinceId(provinceId));
        } catch (Exception e) {
            e.printStackTrace();
            generalResponse.setResponseCode(Constants.ERROR_CODE);
            generalResponse.setResponseCode(Constants.ERROR_MESSAGE);
        }
        log.info("GetByProvinceId Request : " + provinceId);
        log.info("GetByProvinceId Response : " + ObjectMapperUtils.toJson(generalResponse));
        return generalResponse;
    }

    public Page<Regency> getAllRegency(String name, Integer page, Integer size) {
        return regencyRepository.searchAllByName(name, PageRequest.of(page, size));
    }

}
