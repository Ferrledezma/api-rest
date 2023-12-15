package com.example.springboot.social_network.repository.implement;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.social_network.constant.ConstantParam;
import com.example.springboot.social_network.constant.ConstantSqlQuery;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.repository.model.RepositoryInterface;

@Repository
public interface PublicationRepository extends RepositoryInterface<PublicationEntity> {
	@Query(value = ConstantSqlQuery.EXISTS_USER_PUBLICATION, nativeQuery = true)
	public Integer existsPublicationByUserId(
			@Param(ConstantParam.MAIN_ID_PARAM) Long publicationId,
			@Param(ConstantParam.USER_PARAM_NAME) Long userId
			);
	
	@Query(value = ConstantSqlQuery.FIND_PUBLICATION_BY_USER_ID, nativeQuery = true)
	public List<PublicationEntity> findPublicationsByUserId(@Param(ConstantParam.USER_PARAM_NAME) Long userId);
}
