package com.app.service.generic;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Class that implements MessageService
 * 
 * @author David García Prados
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String message) {
		return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
	}

	@Override
	public String getMessage(String message, Locale locale) {
		return messageSource.getMessage(message, null, locale);
	}
}
