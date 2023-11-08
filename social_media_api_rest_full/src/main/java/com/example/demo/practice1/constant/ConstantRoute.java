package com.example.demo.practice1.constant;

public abstract class ConstantRoute {
	/*Identifiers*/
	public static final String ID_IDENTIFIER = "{" + ConstantParamName.ID_NAME + "}";
	public static final String SUB_ID_IDENTIFIER = "{" + ConstantParamName.SUB_ID_NAME + "}";
	
	/*default path*/
	public static final String DEFAULT_ROUTE_NAME = "/api/";
	public static final String CREATED_ROUTE = "/create";
	public static final String UPDATE_ROUTE = "/update/" + ID_IDENTIFIER;
	public static final String DELETE_ROUTE = "/delete/" + ID_IDENTIFIER;
	public static final String FIND_ROUTE = "/find/" + ID_IDENTIFIER;
	public static final String FIND_ALL_ROUTE = "/findAll";
	public static final String FIND_BY_PAGE = "/findByPage";
	
	/*Entities mapping path*/
	public static final String PUBLICATION_ROUTE = DEFAULT_ROUTE_NAME + ConstantTableName.PUBLICATION_TABLE;
	public static final String COMMENT_ROUTE = PUBLICATION_ROUTE + "/find/" + SUB_ID_IDENTIFIER + "/" + ConstantTableName.COMMENT_TABLE;
}
