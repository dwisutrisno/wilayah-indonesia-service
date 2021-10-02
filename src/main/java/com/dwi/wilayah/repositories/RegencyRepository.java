package com.dwi.wilayah.repositories;

import com.dwi.wilayah.models.db.Regency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//created By Dwi Sutrisno - Maret 2021

@Repository
public interface RegencyRepository extends JpaRepository<Regency, String> {

    List<Regency> findByProvinceId(String provinceId);

    @Query("SELECT r FROM regencies r WHERE r.name LIKE %?1% ")
    Page<Regency> searchAllByName(String name, Pageable page);

}
