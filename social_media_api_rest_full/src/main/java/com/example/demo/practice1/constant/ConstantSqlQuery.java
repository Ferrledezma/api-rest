package com.example.demo.practice1.constant;

public abstract class ConstantSqlQuery {
	public static final String EXISTS_PUBLICATION_COMMENT = "SELECT CASE WHEN EXISTS (SELECT 1 FROM " + ConstantTableName.COMMENT_TABLE
			+ " WHERE " + ConstantTableName.ID_COLUMN + " = :" + ConstantParamName.SQL_COMMENT_PARAM + " AND " + ConstantTableName.PUBLICATION_COLUMN_ID
			+ " = :" + ConstantParamName.SQL_PUBLICATION_PARAM + ") THEN TRUE ELSE FALSE END";
	
	public static final String FIND_COMMENT_BY_PUBLICATION_ID = "SELECT * FROM " + ConstantTableName.COMMENT_TABLE + " WHERE " 
			+ ConstantTableName.PUBLICATION_COLUMN_ID + " = :" + ConstantParamName.SQL_PUBLICATION_PARAM;
}
