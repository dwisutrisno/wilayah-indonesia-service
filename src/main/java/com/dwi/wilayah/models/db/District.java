package com.dwi.wilayah.models.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//created By Dwi Sutrisno - Maret 2021

@Data
@Entity(name = "districts")
public class District {

    @Id
    private String id;
    private String regencyId;
    private String name;

}
