package com.example.demo.social_network.constant;

public abstract class ConstantSqlQuery {
	
	public static final String DELETE_RESOURCE_IN_INTERMEDIARY_TABLE = "DELETE FROM " + ConstantTableName.USER_RELATION_TABLE + " WHERE " + ConstantTableName.USER_COLUMN_ID
			+ " = ?" + " OR " + ConstantTableName.FRIEND_USER_ID_COLUMN + " = ?";

	public static final String FIND_PUBLICATION_BY_USER_ID = "SELECT * FROM " + ConstantTableName.PUBLICATION_TABLE + " WHERE " + ConstantTableName.USER_COLUMN_ID
			+ " = :" + ConstantParamName.COLUMN_VALUE_PARAM;
	
	public static final String EXISTS_BY_ID_AND_PUBLICATION_ID = "SELECT CASE WHEN EXISTS (SELECT 1 FROM " + ConstantTableName.COMMENT_TABLE + " WHERE "
			+ ConstantTableName.ID_NAME + " = :" + ConstantParamName.ID_VALUE_PARAM + " AND " + ConstantTableName.PUBLICATION_COLUMN_ID
			+ "= :" + ConstantParamName.COLUMN_VALUE_PARAM + ") THEN TRUE ELSE FALSE END";
	
	public static final String FIND_COMMENT_BY_USER_ID_AND_PUBLICATION_ID = "SELECT * FROM " + ConstantTableName.COMMENT_TABLE + " WHERE " + ConstantTableName.USER_COLUMN_ID
			+ " = :" + ConstantParamName.ID_VALUE_PARAM + " AND " + ConstantTableName.PUBLICATION_COLUMN_ID + " = :" + ConstantParamName.COLUMN_VALUE_PARAM;
	
	public static final String EXISTS_BY_ID_AND_USER_ID = "SELECT EXISTS (SELECT 1 FROM " + ConstantTableName.PUBLICATION_TABLE + " WHERE " + ConstantTableName.ID_NAME
			+ " = :" + ConstantParamName.ID_VALUE_PARAM + " AND " + ConstantTableName.USER_COLUMN_ID + " = :" + ConstantParamName.COLUMN_VALUE_PARAM
			+ ")";
}
