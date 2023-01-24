package com.msunitofmeasurement.service;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.msunitofmeasurement.model.UnitOfMeasurement;

@Repository
public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {

}
