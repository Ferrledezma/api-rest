package com.example.demo.practice1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.practice1.constant.ConstantParamName;
import com.example.demo.practice1.constant.ConstantSqlQuery;
import com.example.demo.practice1.entities.CommentEntity;

@Repository
public interface CommentRepository extends RepositoryInterface<CommentEntity> {
	@Query(value = ConstantSqlQuery.EXISTS_PUBLICATION_COMMENT, nativeQuery = true)
	public int existsPublicationComment(@Param(ConstantParamName.SQL_COMMENT_PARAM) Long commentId, @Param(ConstantParamName.SQL_PUBLICATION_PARAM) Long publicationId);
	
	@Query(value = ConstantSqlQuery.FIND_COMMENT_BY_PUBLICATION_ID, nativeQuery = true)
	public List<CommentEntity> findCommentByPublicationId(@Param(ConstantParamName.SQL_PUBLICATION_PARAM) Long publicationId);
}
