package com.example.springboot.social_network.constant;

public abstract class ConstantPath {
	public static final String DEFAULT_PATH = "/api/";
	
	public static final String UPDATE = "/update/";
	public static final String FIND = "/find/";
	public static final String DELETE = "/delete/";
	public static final String CREATE = "/create/";
	public static final String FIND_ALL = "/findAll";
	public static final String FIND_BY_PAGE = "/find_by_page";
	
	public static final String UPDATE_BY_IDENTIFIER = UPDATE + ConstantParam.ID_PARAM_IDENTIFIER;
	public static final String FIND_BY_IDENTIFIER = FIND + ConstantParam.ID_PARAM_IDENTIFIER;
	public static final String DELETE_BY_IDENTIFIER = DELETE + ConstantParam.ID_PARAM_IDENTIFIER;
	
	public static final String USER_PATH = DEFAULT_PATH + ConstantTableName.USER_TABLE_NAME;
	public static final String PUBLICATION_PATH = USER_PATH + FIND + ConstantParam.USER_PARAM_IDENTIFIER + "/" + ConstantTableName.PUBLICATION_TABLE_NAME;
	public static final String COMMENT_PATH = PUBLICATION_PATH + FIND + ConstantParam.PUBLICATION_PARAM_IDENTIFIER + "/" + ConstantTableName.COMMENT_TABLE_NAME;
}
