package com.example.springboot.social_network.repository.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import com.example.springboot.social_network.constant.ConstantSqlQuery;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Repository
@Validated
public class IntermediaryTableRepository {
	@Autowired
	private JdbcTemplate managementTable;
	
	public void deleteRecord(@NotNull @Positive Long id) {
		managementTable.update(ConstantSqlQuery.DELETE_RECORD_FROM_INTERMEDIARY_TABLE, id, id);
	}
	
	public boolean existsRecordInTable(@NotNull @Positive Long id) {
		int result = managementTable.queryForObject(ConstantSqlQuery.EXISTS_USER_IN_INTERMEDIARY_TABLE, Integer.class, id, id);
		
		return result == 1;
	}
}
