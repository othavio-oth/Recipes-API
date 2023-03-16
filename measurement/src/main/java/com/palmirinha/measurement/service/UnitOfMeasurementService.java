package com.palmirinha.measurement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.palmirinha.measurement.model.UnitOfMeasurement;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitOfMeasurementService {

	private final UnitOfMeasurementRepository repository;

	public UnitOfMeasurement save(UnitOfMeasurement unitOfMeasurement) {
		return repository.save(unitOfMeasurement);
	}

	public List<UnitOfMeasurement> getAll() {
		return repository.findAll();
	}

	public UnitOfMeasurement getById(Long id) throws Exception {
		Optional<UnitOfMeasurement> unitOfMeasurement = repository.findById(id);
		if (unitOfMeasurement.isEmpty()) {
			throw new Exception("Not Found");
		}
		return unitOfMeasurement.get();
	}

	public void delete(Long id) throws Exception {
		UnitOfMeasurement unitOfMeasurement = getById(id);
		repository.delete(unitOfMeasurement);
	}

}
