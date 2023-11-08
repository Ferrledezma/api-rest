package com.example.demo.practice2.constant;

public abstract class ConstantPath {
	
	public static final String MAIN_ID_IDENTIFIER = "{" + ConstantParamName.MAIN_ID_NAME + "}";
	public static final String SUB_SECOND_ID_IDENTIFIER = "{" + ConstantParamName.SUB_SECOND_ID + "}";
	public static final String SUB_THIRD_ID_IDENTIFIER = "{" + ConstantParamName.SUB_THIRD_ID + "}";
	
	public static final String DEFAULT_PATH = "/api/";

	public static final String CREATE_PATH = "/create";
	public static final String UPDATE_PATH = "/update/" + MAIN_ID_IDENTIFIER;
	public static final String DELETE_PATH = "/delete/" + MAIN_ID_IDENTIFIER;
	public static final String FIND_PATH = "/find/" + MAIN_ID_IDENTIFIER;
	public static final String FIND_ALL_PATH = "/findAll";
	public static final String FIND_ALL_BY_PAGE_PATH = "/findAll_byPage";
	
	public static final String USER_PATH = DEFAULT_PATH + ConstantTableName.USER_TABLE;
	public static final String PUBLICATION_PATH = USER_PATH + "/find/" + SUB_SECOND_ID_IDENTIFIER + "/" + ConstantTableName.PUBLICATION_TABLE;
	
	public static final String COMMENT_PATH = USER_PATH + "/find/" + SUB_THIRD_ID_IDENTIFIER + "/" + ConstantTableName.PUBLICATION_TABLE + "/find/"
			+ SUB_SECOND_ID_IDENTIFIER + "/" + ConstantTableName.COMMENT_TABLE;
}
