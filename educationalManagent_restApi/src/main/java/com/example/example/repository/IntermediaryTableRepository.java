package com.example.practica4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IntermediaryTableRepository {
	@Autowired
	JdbcTemplate sqlTemplate;

	public void deleteIntermediaryRelation(String intermediaryTable,String referenceColumn, Long id) throws RuntimeException {
		if(intermediaryTable != null && referenceColumn != null && id != null) {
			String sqlSentency = "DELETE FROM " + intermediaryTable + " WHERE " + referenceColumn + " = ?";
			sqlTemplate.update(sqlSentency, id);
		} else {
			throw new RuntimeException("Los datos de eliminacion de la tabla intermedia no pueden ser nulos");
		}
	}
}
