package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aula")
@NoArgsConstructor
@Getter
public class ClassroomEntity extends AbstractGeneralEntityModel {
	/*Properties*/
	@ManyToOne
	@JoinColumn(name = "instituto_id", referencedColumnName = "id")
	private InstituteEntity institute;
	
	@Column(name = "numero_aula")
	@Setter
	private Integer classroomNumber;
	
	@ManyToMany(mappedBy = "classrooms")
	@JsonManagedReference
	private Set<TeacherEntity> teachers = new HashSet<>();
	
	@OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<StudentEntity> students = new HashSet<>();

	/*Constructs*/
	public ClassroomEntity(InstituteEntity institute) {
		this.institute = institute;
	}
}










