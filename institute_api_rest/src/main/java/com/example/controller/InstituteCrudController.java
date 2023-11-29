package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.aula.ClassroomDTOGet;
import com.example.dto.instituto.InstituteDTOGet;
import com.example.dto.instituto.InstituteDTOPost;
import com.example.dto.instituto.InstituteDTOUpdate;
import com.example.entities.InstituteEntity;
import com.example.service.InstituteService;

@RestController
@RequestMapping("/api/instituto")
public class InstituteCrudController extends CrudModelController<InstituteEntity, InstituteDTOPost, InstituteDTOGet, InstituteDTOUpdate> {
	@Autowired
	private InstituteService instituteService;
	
	@GetMapping("/find/instituto/{instituto_id}/aula/{numero_aula}")
	public ResponseEntity<ClassroomDTOGet> findInstituteClassroom(
			@PathVariable(name = "instituto_id") Long instituteId,
			@PathVariable(name = "numero_aula") Integer classroomNumber){
		
		ClassroomDTOGet classroomDTO = instituteService.getInstituteClassroom(instituteId, classroomNumber);
	
		if(classroomDTO == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(classroomDTO);
	}
	
	@GetMapping("/find/instituto/{id}/aulas")
	public ResponseEntity<List<ClassroomDTOGet>> findAllInstituteClassroom(@PathVariable Long id){
		List<ClassroomDTOGet> classroomDTOList = instituteService.findAllInstituteClassroom(id);
		if(classroomDTOList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(classroomDTOList);
	}
}
















