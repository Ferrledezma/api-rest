package com.example.demo.social_network.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.social_network.constant.ConstantSqlQuery;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Repository
public class TablesManagent {
	@Autowired
	JdbcTemplate sqlManagent;

	public void deleteIntermediaryRecordById(@NotNull @Positive Long id) throws ConstraintViolationException {
		sqlManagent.update(ConstantSqlQuery.DELETE_RESOURCE_IN_INTERMEDIARY_TABLE, id, id);
	}
}
