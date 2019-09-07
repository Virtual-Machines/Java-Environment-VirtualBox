package com.app.config;

import java.util.Locale;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.app.constant.CoreConstants;
import com.app.service.generic.MailService;
import com.app.util.MessageUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * App configuration: Locale, Messages, Mail and DB (connection and Hibernate)
 * 
 * @author David García Prados
 *
 */
@Configuration
@PropertySource(CoreConstants.APPLICATION_PROPERTIES_PATH)
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan(CoreConstants.PACKAGE_BASE_NAME) })
public class AppConfig {

	@Autowired
	private Environment env;

	/**
	 * Locale resolver configuration. Uses CookieLocaleResolver (instead of
	 * SessionLocaleResolver) to remember locale/language after logout
	 * 
	 * @return LocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return cookieLocaleResolver;
	}

	/**
	 * Message properties (text literals) configuration
	 * 
	 * @return MessageSource
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(CoreConstants.MESSAGES_PATH);
		messageSource.setDefaultEncoding(CoreConstants.UTF_8);
		// Reload check to detect changes in message properties
		messageSource.setCacheSeconds(0);

		// Add messageSource to messageUtils to be accessed in a static way
		MessageUtils.setMessageSource(messageSource);

		return messageSource;
	}

	/**
	 * Mail configuration
	 * 
	 * @return MailService
	 */
	@Bean
	public MailService mailService(MailService mailService) {
		Properties props = new Properties();
		props.setProperty(CoreConstants.MAIL_SMTP_AUTH, env.getProperty(CoreConstants.MAIL_SMTP_AUTH));
		props.setProperty(CoreConstants.MAIL_SMTP_HOST, env.getProperty(CoreConstants.MAIL_SMTP_HOST));
		props.setProperty(CoreConstants.MAIL_SMTP_FROM, env.getProperty(CoreConstants.MAIL_SMTP_FROM));
		props.setProperty(CoreConstants.MAIL_SMTP_SEND_PARTIAL, env.getProperty(CoreConstants.MAIL_SMTP_SEND_PARTIAL));
		mailService.setProperties(props, env.getProperty(CoreConstants.MAIL_USERNAME),
				env.getProperty(CoreConstants.MAIL_PASS));
		return mailService;
	}

	/**
	 * Method that configs datasource. Uses Hikari Connection Pool
	 * 
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty(CoreConstants.DB_DRIVER_CLASS));
		hikariConfig.setJdbcUrl(env.getProperty(CoreConstants.DB_JDBC_URL));
		hikariConfig.setUsername(env.getProperty(CoreConstants.DB_USERNAME));
		hikariConfig.setPassword(env.getProperty(CoreConstants.DB_PASS));
		return new HikariDataSource(hikariConfig);
	}

	/**
	 * Private method that configs Hibernate
	 * 
	 * @return Properties
	 */
	private Properties hibernateProps() {
		Properties props = new Properties();
		props.put(CoreConstants.HIBERNATE_SHOW_SQL, env.getProperty(CoreConstants.HIBERNATE_SHOW_SQL));
		props.put(CoreConstants.HIBERNATE_HBM_2_DDL_AUTO, env.getProperty(CoreConstants.HIBERNATE_HBM_2_DDL_AUTO));
		return props;
	}

	/**
	 * Database and Hibernate session configuration
	 * 
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(CoreConstants.PACKAGE_MODEL);
		factoryBean.setHibernateProperties(hibernateProps());
		return factoryBean;
	}

	/**
	 * Hibernate Transactions Config
	 * 
	 * @return HibernateTransactionManager
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
