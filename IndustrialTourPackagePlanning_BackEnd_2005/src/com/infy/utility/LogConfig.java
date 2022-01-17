package com.infy.utility;

import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.status.StatusLogger;

public class LogConfig {
	
	static {
		StatusLogger.getLogger().setLevel(Level.OFF);
		((LoggerContext) LogManager.getContext(false)).setConfigLocation(new File("src/com/infy/resources/log4j2.xml").toURI());
	}
	public static Logger getLogger(Class<?> cla) {
		return LogManager.getLogger(cla);
	}
}
