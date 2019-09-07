package com.app.service.generic;

import java.util.Locale;

/**
 * Service that obtains messages from identifiers in message.properties
 * 
 * @author David García Prados
 *
 */

public interface MessageService {

	/**
	 * Method that gets message from identifier using default context locale
	 * 
	 * @param message
	 * @return String
	 */

	String getMessage(String messageId);

	/**
	 * Method that gets message from identifier and locale passed as parameters
	 * 
	 * @param message
	 * @param locale
	 * @return String
	 */

	String getMessage(String messageId, Locale locale);

}
