import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

public class LoggerDemo {

	public static void main(String[] args) {
		// Configure Log4j before using the logger
		//PropertyConfigurator.configure("/Users/kavitha/Documents/workspace/Log4JDemo/Log4j.Properties");
		Logger logger = Logger.getLogger("LoggerDemo");

		logger.info("Starting application");
		
//		
//
//		try {
//			// Your application logic here (may throw exceptions)
//			logger.debug("This is debug");
//			logger.info("This is info");
//			logger.warning("This is warn");
//		} catch (Exception e) {
//			logger.error("An error occurred: " + e.getMessage(), e); // Log the exception message and stack trace
//		}
//
//		logger.fatal("This is fatal (should not be reached during normal operation)"); // Use fatal sparingly for
//																						// critical issues
//		System.out.println("Log4j demo");
	}

}
