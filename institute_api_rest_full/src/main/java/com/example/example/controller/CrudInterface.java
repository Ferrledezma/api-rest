package com.example.practica4.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudInterface <Entity, DtoPost, DtoGet, DtoUpdate> {
	public ResponseEntity<Entity> create(@RequestBody DtoPost dtoPost);
	public ResponseEntity<DtoGet> update(@PathVariable Long id, @RequestBody DtoUpdate dtoUpdate);
	public ResponseEntity<Void> delete(@PathVariable Long id);
	public ResponseEntity<DtoGet> find(@PathVariable Long id);
	public ResponseEntity<List<DtoGet>> findAll();
}
