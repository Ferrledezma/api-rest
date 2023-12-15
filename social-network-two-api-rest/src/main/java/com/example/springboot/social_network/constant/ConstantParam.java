package com.example.springboot.social_network.constant;

public abstract class ConstantParam {
	public static final String MAIN_ID_PARAM = "main_" + ConstantColumnName.ID_COLUMN_NAME;
	public static final String USER_PARAM_NAME = "user_" + ConstantColumnName.ID_COLUMN_NAME;
	public static final String PUBLICATION_PARAM_NAME = "publication_" + ConstantColumnName.ID_COLUMN_NAME;
	
	public static final String ID_PARAM_IDENTIFIER = "{" + MAIN_ID_PARAM + "}";
	public static final String USER_PARAM_IDENTIFIER = "{" + USER_PARAM_NAME + "}";
	public static final String PUBLICATION_PARAM_IDENTIFIER = "{" + PUBLICATION_PARAM_NAME + "}";
}
