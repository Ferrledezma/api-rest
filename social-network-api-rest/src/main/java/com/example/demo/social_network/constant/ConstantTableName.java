package com.example.demo.social_network.constant;

public abstract class ConstantTableName {
	public static final String USER_TABLE = "usuario";
	public static final String PUBLICATION_TABLE = "publicacion";
	public static final String COMMENT_TABLE = "comentario";
	public static final String USER_RELATION_TABLE = USER_TABLE + "_amigos";
	
	public static final String ID_NAME = "id";
	public static final String CONTENT_COLUMN = "contenido";
	
	public static final String USER_COLUMN_ID = USER_TABLE + "_" + ID_NAME;
	public static final String FRIEND_USER_ID_COLUMN = USER_TABLE + "_amigo_" + ID_NAME;
	public static final String PUBLICATION_COLUMN_ID = PUBLICATION_TABLE + "_" + ID_NAME;
}
