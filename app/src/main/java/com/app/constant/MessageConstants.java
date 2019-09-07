package com.app.constant;

/**
 * Constants with the ids of messages.properties
 * 
 * @author David García Prados
 *
 */
public class MessageConstants {

	/**
	 * Utility classes, which are collections of static members, are not meant to be
	 * instantiated. Even abstract utility classes, which can be extended, should
	 * not have public constructors.
	 * 
	 * Java adds an implicit public constructor to every class which does not define
	 * at least one explicitly. Hence, at least one non-public constructor should be
	 * defined.
	 */
	private MessageConstants() {
	}

	/*
	 * Constants with the ids of messages.properties
	 */

	public static final String TEXT_YES = "text.yes";
	public static final String TEXT_NO = "text.no";
	public static final String USERDETAIL_ERROR_USERNAME_EXISTS = "userdetail.error.usernameExists";

}
