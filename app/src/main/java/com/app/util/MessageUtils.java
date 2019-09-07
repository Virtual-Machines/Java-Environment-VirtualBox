package com.app.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Utility class that statically obtains messages from identifiers in
 * message.properties
 * 
 * @author David García Prados
 *
 */
public class MessageUtils {

	private MessageUtils() {

	}

	private static MessageSource staticMessageSource;

	public static void setMessageSource(MessageSource messageSource) {
		staticMessageSource = messageSource;
	}

	/**
	 * Method that gets message from identifier using default context locale
	 * 
	 * @param message
	 * @return String
	 */
	public static String getMessage(String message) {
		return staticMessageSource.getMessage(message, null, LocaleContextHolder.getLocale());
	}

	/**
	 * Method that gets message from identifier and locale passed as parameters
	 * 
	 * @param message
	 * @param locale
	 * @return String
	 */
	public static String getMessage(String message, Locale locale) {
		return staticMessageSource.getMessage(message, null, locale);
	}

}
