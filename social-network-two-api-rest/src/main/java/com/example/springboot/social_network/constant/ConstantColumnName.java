package com.example.springboot.social_network.constant;

public abstract class ConstantColumnName {
	public static final String ID_COLUMN_NAME = "id";
	public static final String USER_COLUMN_NAME = "usuario_" + ID_COLUMN_NAME;
	public static final String PUBLICATION_COLUMN_NAME = "publicacion_" + ID_COLUMN_NAME;
	public static final String USER_COLUMN_ID_TWO = USER_COLUMN_NAME + "_2";
}
