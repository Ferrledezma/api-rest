package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instituto")
@NoArgsConstructor
@Getter
@Setter
public class InstituteEntity extends AbstractEntityModel {
	/*Properties*/
	@OneToMany(mappedBy = "institute", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonBackReference
	private Set<ClassroomEntity> classrooms = new HashSet<>();
	
	@ManyToMany(mappedBy = "institutes")
	@JsonBackReference
	private Set<TeacherEntity> teachers = new HashSet<>();
	
	@OneToMany(mappedBy = "institute", orphanRemoval = false)
	@JsonBackReference
	private Set<StudentEntity> students = new HashSet<>();
	
	/*Constructs*/
	public InstituteEntity(String name) {
		super(name);
	}
	
	public <T> void addRelations(T entity) {
		if(entity != null) {
			if(entity instanceof ClassroomEntity) {
				ClassroomEntity aula = (ClassroomEntity) entity;
				aula.setClassroomNumber(classrooms.size() + 1);
				classrooms.add(aula);
			} else if(entity instanceof TeacherEntity) {
				teachers.add((TeacherEntity) entity);
			} else if(entity instanceof StudentEntity) {
				students.add((StudentEntity) entity);
			}
		}
	}
	public <T> void removeRelations(T entity) {
		if(entity != null) {
			if(entity instanceof ClassroomEntity) {
				classrooms.remove((ClassroomEntity) entity);
			} else if(entity instanceof TeacherEntity) {
				teachers.remove((TeacherEntity) entity);
			} else if(entity instanceof StudentEntity) {
				students.remove((StudentEntity) entity);
			}
		}
	}
}
















