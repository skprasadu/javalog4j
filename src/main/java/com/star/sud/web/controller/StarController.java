package com.star.sud.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StarController {

	private static final Logger logger = Logger.getLogger(StarController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoginPage(Model model, HttpServletRequest request) {

		// String loc = "D://log-file/";

		String loc = "D://log-file3/admin4.log";

		// updateLog4jConfiguration(loc + "admin" + ".log");
		updateLog4jConfiguration(loc);
		logger.debug("-- Debug message --");
		logger.info("-- Displaying info message--");
		 int a=5;
		 String var="hello";
		 logger.trace("Trace Message!");
		 logger.debug("Debug Message!");
		 logger.info("Info Message!");
		 logger.info("Variable a which is of type int !" + a);
		 logger.info("Variable a which is of type int !" + var);
		 logger.warn("Warn Message!");
		 logger.error("Error Message!");
		 logger.fatal("Fatal Message!");

		model.addAttribute("msg", loc);

		return "login/login-page";
	}

	private void updateLog4jConfiguration(String logFile) {
		Properties props = new Properties();
		try {
			InputStream configStream = getClass().getResourceAsStream("/log4j.properties");
			props.load(configStream);
			configStream.close();
		} catch (IOException e) {
			System.out.println("Error not laod configuration file ");
		}

		props.setProperty("log4j.rootLogger", "DEBUG,Appender2");
		props.setProperty("log4j.appender.Appender2", "org.apache.log4j.RollingFileAppender");
		props.setProperty("log4j.appender.Appender2.File", logFile);
		props.setProperty("log4j.appender.Appender2.MaxFileSize", "10MB");
		props.setProperty("log4j.appender.Appender2.layout", "org.apache.log4j.PatternLayout");

		props.setProperty("log4j.appender.Appender2.layout.ConversionPattern",
				"%d{dd MMM yyyy HH:mm:ss} [%t] %-5p %c %x - %m%n");

		props.setProperty("log4j.logger.org.hibernate", "error");
		props.setProperty("log4j.logger.org.springframework", "error");
		props.setProperty("log4j.logger.org.thymeleaf", "error");

		LogManager.resetConfiguration();
		PropertyConfigurator.configure(props);

	}

}
