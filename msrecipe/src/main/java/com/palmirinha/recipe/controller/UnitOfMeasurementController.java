package com.palmirinha.recipe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palmirinha.recipe.controller.dto.UnitOfMeasurementFormDTO;
import com.palmirinha.recipe.controller.dto.UnitOfMeasurementMapper;
import com.palmirinha.recipe.controller.dto.unitOfMeasurementResponse;
import com.palmirinha.recipe.model.UnitOfMeasurement;
import com.palmirinha.recipe.service.UnitOfMeasurementService;

@RestController
@RequestMapping("v1/units-of-measurement")
public class UnitOfMeasurementController {

	@Autowired	
	private  UnitOfMeasurementService unitOfMeasurementService;
	
	@PostMapping
	public ResponseEntity<unitOfMeasurementResponse> saveUnitOfMeasurement(@RequestBody UnitOfMeasurementFormDTO dto){
		UnitOfMeasurement unitOfMeasurement =  unitOfMeasurementService.save(UnitOfMeasurementMapper.fromDto(dto));
		return ResponseEntity.ok(UnitOfMeasurementMapper.fromEntity(unitOfMeasurement));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<unitOfMeasurementResponse> getUnitOfMeasurement(@PathVariable Long id){
		
		try {
			UnitOfMeasurement unitOfMeasurement = unitOfMeasurementService.getById(id);
			return ResponseEntity.ok(UnitOfMeasurementMapper.fromEntity(unitOfMeasurement));
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
	}

	@GetMapping
	public ResponseEntity<List<unitOfMeasurementResponse>> getAllIngredients(){
		List<UnitOfMeasurement> unitOfMeasurements = unitOfMeasurementService.getAll();
		List<unitOfMeasurementResponse> unitOfMeasurementResponses = unitOfMeasurements.stream()
		.map(UnitOfMeasurementMapper::fromEntity).collect(Collectors.toList());
		return ResponseEntity.ok(unitOfMeasurementResponses);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<unitOfMeasurementResponse> deleteIngredient(@PathVariable Long id){
		try {
			unitOfMeasurementService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
	
}
