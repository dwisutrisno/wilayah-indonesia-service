package com.dwi.wilayah.repositories;

import com.dwi.wilayah.models.db.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//created By Dwi Sutrisno - Maret 2021

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

    List<District> findByRegencyId(String regencyId);

    @Query("SELECT r FROM districts r WHERE r.name LIKE %?1% ")
    Page<District> searchAllByName(String name, Pageable page);

}
