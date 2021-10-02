package com.dwi.wilayah.repositories;

import com.dwi.wilayah.models.db.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//created by Dwi Sutrisno - Maret 2021

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {


}
