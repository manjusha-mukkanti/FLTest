/**
 * 
 */
package com.fissionlabs.java.prbstmt.core;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fissionlabs.java.prbstmt.bean.Employee;
import com.fissionlabs.java.prbstmt.exception.FLInvalidInputException;
import com.fissionlabs.java.prbstmt.exception.FLProcessException;

/**
 * Entry class for solving the the problem statement
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class FLConsoleReader {

	public final static Logger LOGGER = LogManager
			.getLogger(FLConsoleReader.class);

	private List<Employee> data = new Vector<>();
	private ProcessEmp processEmp;
	private SortStoreT sortT;

	/**
	 * Displays welcome message to the user. Accepts input from the user and
	 * delegates the received requests.
	 * 
	 * @throws FLProcessException
	 */
	public void read() throws FLProcessException {
		displayWelcomeMessage();
		Thread swThread = null;
		int threadCount = 1;
		try (Scanner scanner = new Scanner(System.in);) {
			while (true) {
				String input = scanner.nextLine();
				switch (input) {
				case "EXIT":
					if (swThread != null) {
						swThread.join();
					}
					LOGGER.trace("Exiting the application!");
					System.exit(0);
				case "SORT":
					sortT.setEmpList(data);
					swThread = new Thread(sortT, "SortAndStoreThread"+threadCount++);
					swThread.start();
					break;
				default:
					try {
						Employee emp = processEmp.parse(input);
						data.add(emp);
					} catch (FLInvalidInputException exc) {
						System.out
								.println("Entered invalid data. Please enter valid data...");
						LOGGER.error(
								"{} is invalid. Please enter valid data...",
								data, exc);
					}
					displayData();
				}
			}
		} catch (Exception exc) {
			LOGGER.error("Failed to process the input read from console", exc);
			throw new FLProcessException(
					"Failed to process the input read from console", exc);
		}
	}

	/**
	 * @return the processEmp
	 */
	public ProcessEmp getProcessEmp() {
		return processEmp;
	}

	/**
	 * @param processEmp
	 *            the processEmp to set
	 */
	public void setProcessEmp(ProcessEmp processEmp) {
		this.processEmp = processEmp;
	}

	/**
	 * @return the sortT
	 */
	public SortStoreT getSortT() {
		return sortT;
	}

	/**
	 * @param sortT
	 *            the sortT to set
	 */
	public void setSortT(SortStoreT sortT) {
		this.sortT = sortT;
	}

	/**
	 * Welcome message to the user
	 */
	private void displayWelcomeMessage() {
		System.out
				.println("Input​ ​ to​ ​ be​ ​ read​ ​ from​ ​ command​ ​ line.​ ​"
						+ "\nInput​ ​ is​ ​ split​ ​ into​ ​ multiple​ ​ lines."
						+ "\nEach​ ​ line​ ​ of​ ​ input​ ​ can be​ ​ any​ ​ of​ ​ below​ ​ types ");
		System.out
				.println("1. Employee​ ​ data​ ​ in​ ​ the​ ​ string​ ​ format​ ​ as​ ​ below​ ​ :"
						+ "+\n\tFirstName​ ​ (String),​ ​ LastName(String), Experience(Months),​ ​ Age(Years),​ ​ Organization(String)");
		System.out.println("2. “SORT”​ ​ keyword. to sort the input");
		System.out.println("3. “EXIT”​ ​ keyword to exit");
		System.out.println("Start entering your input...");
	}

	/**
	 * Display data for debugging purpose
	 */
	private void displayData() {
		for (Employee msg : data) {
			LOGGER.debug(msg);
		}
	}
}
