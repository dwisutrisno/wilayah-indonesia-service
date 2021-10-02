package com.dwi.wilayah.models.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//created by Dwi Sutrisno - Maret 2021

@Data
@Entity(name = "village")
public class Village {

    @Id
    private String id;
    private String districtId;
    private String name;

}
