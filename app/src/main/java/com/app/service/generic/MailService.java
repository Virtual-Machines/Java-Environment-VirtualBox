package com.app.service.generic;

import java.util.Properties;
import java.util.Set;

/**
 * Service that sends emails
 * 
 * @author David García Prados
 *
 */

public interface MailService {

	/**
	 * Send mail
	 * 
	 * @param subject
	 * @param body
	 * @param to
	 * @param cc
	 * @param bcc
	 */
	public void sendMail(String subject, String body, Set<String> to, Set<String> cc, Set<String> bcc);

	/**
	 * Set properties
	 * 
	 * @param properties
	 * @param username
	 * @param password
	 */
	public void setProperties(Properties properties, String username, String password);

}
