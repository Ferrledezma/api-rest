package com.example.demo.practice2.constant;

public abstract class ConstantParamName {
	public static final String MAIN_ID_NAME = ConstantTableName.ID_NAME;
	public static final String SUB_SECOND_ID = "sub_second_" + MAIN_ID_NAME;
	public static final String SUB_THIRD_ID = "sub_third_" + MAIN_ID_NAME;
	public static final String COLUMN_VALUE_PARAM = "value";
	public static final String ID_VALUE_PARAM = MAIN_ID_NAME + "_value";
	
	public static final String COMMENT_JSON_PARAM_NAME = ConstantTableName.COMMENT_TABLE + "_" + MAIN_ID_NAME;
	public static final String USER_POST_COMMENT_JSON_NAME = ConstantTableName.USER_TABLE + "_post_" + ConstantTableName.COMMENT_TABLE + "_" + MAIN_ID_NAME;
}
