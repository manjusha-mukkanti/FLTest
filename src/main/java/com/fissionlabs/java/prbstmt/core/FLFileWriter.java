/**
 * 
 */
package com.fissionlabs.java.prbstmt.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fissionlabs.java.prbstmt.bean.Employee;
import com.fissionlabs.java.prbstmt.exception.FLProcessException;

/**
 * Writes data to the given file
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class FLFileWriter {
	public final static Logger LOGGER = LogManager
			.getLogger(FLFileWriter.class);

	/**
	 * Dumps employee list in the given path
	 * 
	 * @param empList
	 * @param path
	 */
	public void write(List<Employee> empList, String path)
			throws FLProcessException {

		File file = new File(path);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (Employee employee : empList) {
				bw.write(employee.getInput() + "\n");
			}
		} catch (IOException ioe) {
			throw new FLProcessException(Thread.currentThread().getName()
					+ " failed to write in " + path, ioe);
		}
	}
}
