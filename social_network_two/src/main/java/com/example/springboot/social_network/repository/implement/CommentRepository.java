package com.example.springboot.social_network.repository.implement;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.social_network.constant.ConstantParam;
import com.example.springboot.social_network.constant.ConstantSqlQuery;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.repository.model.RepositoryInterface;

@Repository
public interface CommentRepository extends RepositoryInterface<CommentEntity> {
	@Query(value = ConstantSqlQuery.EXISTS_PUBLICATION_COMMENT, nativeQuery = true)
	public Integer existsCommentByPublicationId(
			@Param(ConstantParam.MAIN_ID_PARAM) Long commentId,
			@Param(ConstantParam.USER_PARAM_NAME) Long userId,
			@Param(ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId
			);
	
	@Query(value = ConstantSqlQuery.FIND_COMMENT_BY_USER_ID, nativeQuery = true)
	public List<CommentEntity> findCommentsByPublicationId(@Param(ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId);
}
