package com.dwi.wilayah.repositories;

import com.dwi.wilayah.models.db.Village;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//created By Dwi Sutrisno - Maret 2021

@Repository
public interface VillageRepository extends JpaRepository<Village, String> {

    List<Village> findByDistrictId(String districtId);

    @Query("SELECT r FROM village r WHERE r.name LIKE %?1% ")
    Page<Village> searchAllByName(String name, Pageable page);


}
