package com.example.practica4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.practica4.entities.ClassroomEntity;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassroomEntity, Long> {
	@Query(value = "SELECT * FROM aula WHERE instituto_id = :inst_id", nativeQuery = true)
	public List<ClassroomEntity> findAllInstituteClassroom(@Param(value = "inst_id") Long instituteId);
	
	@Query(value = "SELECT * FROM aula WHERE instituto_id = :inst_id AND numero_aula = :num_aula LIMIT 1", nativeQuery = true)
	 public Optional<ClassroomEntity> findInstituteClassroom(@Param(value = "inst_id") Long instituteId, @Param(value = "num_aula") Integer classroomNumber);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM aula WHERE numero_aula = :num_aula AND instituto_id = :inst_id", nativeQuery = true)
	public void deleteClassroomInstitute(@Param(value = "num_aula") Integer classroomNumber, @Param(value = "inst_id") Long instituteId);
}
