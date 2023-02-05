package com.palmirinha.recipe.controller.dto;

import com.palmirinha.recipe.model.UnitOfMeasurement;

public class UnitOfMeasurementMapper {
	
	public static UnitOfMeasurement fromDto(UnitOfMeasurementFormDTO dto) {
		return new UnitOfMeasurement(null, dto.getName());
	}

	public static unitOfMeasurementResponse fromEntity(UnitOfMeasurement unitOfMeasurement) {
		return new unitOfMeasurementResponse(unitOfMeasurement.getId(), unitOfMeasurement.getName());
	}
}
