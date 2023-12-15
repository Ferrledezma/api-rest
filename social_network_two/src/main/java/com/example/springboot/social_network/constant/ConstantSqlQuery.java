package com.example.springboot.social_network.constant;

public abstract class ConstantSqlQuery {
	public static final String EXISTS_USER_PUBLICATION = "SELECT EXISTS (SELECT 1 FROM " + ConstantTableName.PUBLICATION_TABLE_NAME
			+ " WHERE " + ConstantColumnName.ID_COLUMN_NAME + " = :" + ConstantParam.MAIN_ID_PARAM + " AND "
			+ ConstantColumnName.USER_COLUMN_NAME  + " = :" + ConstantParam.USER_PARAM_NAME + ")";
	
	public static final String EXISTS_PUBLICATION_COMMENT = "SELECT EXISTS (SELECT 1 FROM " + ConstantTableName.COMMENT_TABLE_NAME
			+ " WHERE " + ConstantColumnName.ID_COLUMN_NAME + " = :" + ConstantParam.MAIN_ID_PARAM + " AND "
			+ ConstantColumnName.USER_COLUMN_NAME + " = :" + ConstantParam.USER_PARAM_NAME + " AND " +ConstantColumnName.PUBLICATION_COLUMN_NAME 
			+ " = :" + ConstantParam.PUBLICATION_PARAM_NAME + ")";
	
	public static final String FIND_PUBLICATION_BY_USER_ID = "SELECT * FROM " + ConstantTableName.PUBLICATION_TABLE_NAME
			+ " WHERE " + ConstantColumnName.USER_COLUMN_NAME + " = :" + ConstantParam.USER_PARAM_NAME;
	
	public static final String FIND_COMMENT_BY_USER_ID = "SELECT * FROM " + ConstantTableName.COMMENT_TABLE_NAME
			+ " WHERE " + ConstantColumnName.PUBLICATION_COLUMN_NAME + " = :" + ConstantParam.PUBLICATION_PARAM_NAME;
	
	public static final String DELETE_RECORD_FROM_INTERMEDIARY_TABLE = "DELETE FROM " + ConstantTableName.USER_FRIENDS_TABLE_NAME + " WHERE "
			+ ConstantColumnName.USER_COLUMN_NAME + " = ? OR " + ConstantColumnName.USER_COLUMN_ID_TWO + " = ?";
	
	public static final String EXISTS_USER_IN_INTERMEDIARY_TABLE = "SELECT EXISTS (SELECT 1 FROM " + ConstantTableName.USER_FRIENDS_TABLE_NAME
			+ " WHERE " + ConstantColumnName.USER_COLUMN_NAME + " = ? OR " + ConstantColumnName.USER_COLUMN_ID_TWO + " = ?)";
}
