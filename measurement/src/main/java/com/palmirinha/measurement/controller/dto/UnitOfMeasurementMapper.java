package com.palmirinha.measurement.controller.dto;

import com.palmirinha.measurement.model.UnitOfMeasurement;

public class UnitOfMeasurementMapper {

	public static UnitOfMeasurement fromDto(UnitOfMeasurementFormDTO dto) {
		return new UnitOfMeasurement(null, dto.getName());
	}

	public static unitOfMeasurementResponse fromEntity(UnitOfMeasurement unitOfMeasurement) {
		return new unitOfMeasurementResponse(unitOfMeasurement.getId(), unitOfMeasurement.getName());
	}
}
