package com.fissionlabs.java.prbstmt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fissionlabs.java.prbstmt.core.FLConsoleReader;
import com.fissionlabs.java.prbstmt.core.ProcessEmp;
import com.fissionlabs.java.prbstmt.core.SortStoreT;
/**
 * 
 * @author Manjusha Mukkanti
 *
 */
@Configuration
@PropertySource(value="classpath:application.properties")
public class AppConfig {

	@Bean
	public FLConsoleReader readConsole() {
		FLConsoleReader reader = new FLConsoleReader();
		reader.setProcessEmp(processEmp());
		reader.setSortT(sortStore());
		return reader;
	}

	@Bean
	public ProcessEmp processEmp() {
		ProcessEmp processEmp = new ProcessEmp();
		return processEmp;
	}
	
	@Bean
	public SortStoreT sortStore()
	{
		return new SortStoreT();
	}
}
