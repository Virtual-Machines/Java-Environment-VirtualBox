package com.app.service.generic;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.app.constant.CoreConstants;

/**
 * Implementation of service that sends emails
 * 
 * @author David García Prados
 *
 */
@Service
public class MailServiceImpl implements MailService {

	private final Logger logger = LogManager.getLogger();

	private Properties properties;

	private Authenticator authenticator;

	/*
	 * Process recipients and add them (if are correct) to message. Register
	 * incorrect ones
	 */
	private void processRecipients(Message.RecipientType recipientType, Set<String> recipients, MimeMessage message,
			Set<String> incorrectFormatMails) {

		for (String recipientMail : recipients) {
			try {
				// Internet Address check strict mode = true
				message.addRecipient(recipientType, new InternetAddress(recipientMail, true));
			} catch (Exception ex) {
				incorrectFormatMails.add(recipientMail);
			}
		}
	}

	@Override
	public void sendMail(String subject, String body, Set<String> to, Set<String> cc, Set<String> bcc) {
		Set<String> errorMails = new HashSet<>();

		try {
			Session session = Session.getInstance(properties, authenticator);
			MimeMessage message = new MimeMessage(session);
			message.setSubject(subject);
			message.setText(body);

			processRecipients(Message.RecipientType.TO, to, message, errorMails);
			processRecipients(Message.RecipientType.CC, cc, message, errorMails);
			processRecipients(Message.RecipientType.BCC, bcc, message, errorMails);

			Transport.send(message);
		}

		// If send failed partially, store only invalid addresses
		catch (SendFailedException sfex) {
			Address[] addresses = sfex.getInvalidAddresses();

			if (addresses != null) {
				for (Address addressElem : addresses) {
					errorMails.add(addressElem.toString());
				}
			}
		}

		catch (Exception ex) {
			logger.error(CoreConstants.ERROR_LOG + ex);
		}

		// Log error
		if (!errorMails.isEmpty()) {
			logger.error(CoreConstants.ERROR_LOG + " " + subject + "-" + body + " Incorrect mails: " + errorMails);
		}
	}

	@Override
	public void setProperties(Properties properties, String username, String password) {
		this.properties = properties;
		this.authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
	}
}
