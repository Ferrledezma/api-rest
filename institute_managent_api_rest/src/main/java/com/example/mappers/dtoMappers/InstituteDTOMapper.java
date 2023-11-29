package com.example.mappers.dtoMappers;

import org.springframework.stereotype.Component;

import com.example.dto.instituto.InstituteDTOGet;
import com.example.entities.InstituteEntity;

@Component
public class InstituteDTOMapper implements DTOMapperInterface<InstituteEntity, InstituteDTOGet> {

	@Override
	public InstituteDTOGet apply(InstituteEntity instituto) {
		return new InstituteDTOGet(
				instituto.getName(),
				instituto.getClassrooms().size(),
				instituto.getTeachers().size(),
				instituto.getStudents().size()
				);
	}

}
