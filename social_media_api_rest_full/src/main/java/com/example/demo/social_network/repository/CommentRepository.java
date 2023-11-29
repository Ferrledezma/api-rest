package com.example.demo.social_network.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.social_network.constant.ConstantParamName;
import com.example.demo.social_network.constant.ConstantSqlQuery;
import com.example.demo.social_network.entities.CommentEntity;

@Repository
public interface CommentRepository extends RepositoryInterface<CommentEntity> {
	@Query(value = ConstantSqlQuery.EXISTS_BY_ID_AND_PUBLICATION_ID, nativeQuery = true)
	public Integer existsByIdAndPublicationId(@Param(ConstantParamName.ID_VALUE_PARAM) Long commentId, @Param(ConstantParamName.COLUMN_VALUE_PARAM) Long publicationId);
	
	@Query(value = ConstantSqlQuery.FIND_COMMENT_BY_USER_ID_AND_PUBLICATION_ID, nativeQuery = true)
	public List<CommentEntity> findCommentByPublicationId(@Param(value = ConstantParamName.ID_VALUE_PARAM) Long userId, @Param(value = ConstantParamName.COLUMN_VALUE_PARAM) Long publicationId);
}
