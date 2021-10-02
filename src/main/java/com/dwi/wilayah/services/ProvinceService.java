package com.dwi.wilayah.services;

import com.dwi.wilayah.models.response.GeneralResponse;
import com.dwi.wilayah.utilities.Constants;
import com.dwi.wilayah.repositories.ProvinceRepository;
import org.springframework.stereotype.Service;

//created by Dwi Sutrisno - Maret 2021

@Service
public class ProvinceService {

    final ProvinceRepository provinceRepository;


    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }


    public GeneralResponse getAllProvince() {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            generalResponse.setResponseCode(Constants.SUCCESS_CODE);
            generalResponse.setResponseMessage(Constants.SUCCESS_MESSAGE);
            generalResponse.setResponseContent(provinceRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            generalResponse.setResponseCode(Constants.ERROR_CODE);
            generalResponse.setResponseCode(Constants.ERROR_MESSAGE);
        }
        return generalResponse;
    }


}
