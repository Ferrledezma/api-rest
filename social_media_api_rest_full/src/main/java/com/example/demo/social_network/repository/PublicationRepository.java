package com.example.demo.social_network.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.social_network.constant.ConstantParamName;
import com.example.demo.social_network.constant.ConstantSqlQuery;
import com.example.demo.social_network.entities.PublicationEntity;

@Repository
public interface PublicationRepository extends RepositoryInterface<PublicationEntity> {
	
	@Query(value = ConstantSqlQuery.FIND_PUBLICATION_BY_USER_ID, nativeQuery = true)
	public List<PublicationEntity> findPublicationByUserId(@Param(ConstantParamName.COLUMN_VALUE_PARAM) Long idValue);
	
	@Query(value = ConstantSqlQuery.EXISTS_BY_ID_AND_USER_ID, nativeQuery = true)
	public Integer existsByIdAndUserId(
			@Param(ConstantParamName.ID_VALUE_PARAM) Long publicationId,
			@Param(value = ConstantParamName.COLUMN_VALUE_PARAM) Long userId
			);
}
