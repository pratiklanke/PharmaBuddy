package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Medicine;

public interface MedicineDAO extends JpaRepository<Medicine, Long> {

}
