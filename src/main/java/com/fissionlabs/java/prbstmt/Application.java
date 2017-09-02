/**
 * 
 */
package com.fissionlabs.java.prbstmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fissionlabs.java.prbstmt.core.FLConsoleReader;

/**
 * @author Manjusha Mukkanti
 * 
 */
public class Application {

	public final static Logger LOGGER = LogManager.getLogger(Application.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LOGGER.trace("Starting application...");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class)) {
			FLConsoleReader readConsole = ctx.getBean(FLConsoleReader.class);
			readConsole.read();
		} catch (Exception exe) {
			LOGGER.error("Exception in main program", exe);
		}
	}
}
