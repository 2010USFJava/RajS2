package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	static Logger logger = LogManager.getLogger();
	
	public static void LogIt(String level, String message) {
		switch(level) {
		case "fatal":
			logger.fatal(message);
			break;
		case "error":
			logger.error(message);
			break;
		case "warn":
			logger.warn(message);
			break;
		case "info":
			logger.info(message);
			break;
		case "debug":
			logger.debug(message);
			break;
		case "trace":
			logger.trace(message);
			break;
		default:
			System.out.println("Logger is not working");
			break;
		}
	}
}
