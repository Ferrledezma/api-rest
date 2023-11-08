package com.example.practica4.extras;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica4.entities.ClassroomEntity;
import com.example.practica4.entities.InstituteEntity;
import com.example.practica4.repository.ClassroomRepository;
import com.example.practica4.repository.InstituteRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class RelateInstituteAndClassrooms {
	/*Dependencies*/
	@Autowired
	private InstituteRepository instituteRepository;
	@Autowired
	private ClassroomRepository classroomRepository;
	
	/*Methods*/
	public void relate(Consumer<InstituteEntity> instituteMethod, Consumer<Set<ClassroomEntity>> classroomMethod, Long instituteId, List<Integer> classroomNumberList)
			throws EntityNotFoundException, RuntimeException {
		if(instituteId == null) {
			return;
		}
		
		InstituteEntity institute = instituteRepository.findById(instituteId)
				.orElseThrow(() -> new EntityNotFoundException("La entidad con el id '" + instituteId + "' no existe en la DB"));
		
		instituteMethod.accept(institute);
		
		if(classroomNumberList != null && !classroomNumberList.isEmpty()) {
			Set<ClassroomEntity> classroomList = classroomNumberList
					.stream()
					.map(number ->
						classroomRepository
						.findInstituteClassroom(instituteId, number)
						.orElseThrow(() -> new RuntimeException(
								"La entidad instituto no contiene un aula con el numero '" + number + "' en la DB"
								))
					)
					.collect(Collectors.toSet());
			
			classroomMethod.accept(classroomList);
		}
	}
}












