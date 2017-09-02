package com.fissionlabs.java.prbstmt.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.fissionlabs.java.prbstmt.bean.Employee;
import com.fissionlabs.java.prbstmt.exception.FLInvalidInputException;

/**
 * Parse the input given by user
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class ProcessEmp {

	public final static Logger LOGGER = LogManager.getLogger(ProcessEmp.class);

	/**
	 * Parse given string as : FirstName​ ​ (String),​ ​ LastName(String),
	 * Experience(Months),​ ​ Age(Years),​ ​ Organization(String)
	 * 
	 * @param input
	 * @return
	 * @throws FLInvalidInputException
	 */
	public Employee parse(String input) throws FLInvalidInputException {
		LOGGER.debug("Parsing {} ", input);
		Employee employee = null;

		String[] splitData = parseString(input).split(",");
		if (splitData == null) {
			throw new FLInvalidInputException("Entered invalid data");
		} else if (splitData.length == 5) {
			employee = new Employee();
			employee.setInput(input);
			StringBuffer allFields = new StringBuffer();
			employee.setFirstName(parseString(splitData[0], allFields));
			employee.setLastName(parseString(splitData[1], allFields));
			employee.setExpInMnths(parseNumber(splitData[2], allFields));
			employee.setAgeInYrs(parseNumber(splitData[3], allFields));
			employee.setOrganization(parseString(splitData[4], allFields));
			employee.setAllFields(allFields.toString());

			LOGGER.debug("Parsed as {}", employee.getAllFields());
		} else {
			throw new FLInvalidInputException("Insufficient fields entered");
		}
		return employee;
	}

	/**
	 * 
	 * @param data
	 * @param allFields
	 * @return
	 * @throws FLInvalidInputException
	 */
	private int parseNumber(String data, StringBuffer allFields)
			throws FLInvalidInputException {
		int parsedNum = 0;
		String number = parseString(data, allFields);
		try {
			parsedNum = Integer.parseInt(number);
			if (parsedNum == 0) {
				throw new FLInvalidInputException("O is invalid number.");
			}
		} catch (NumberFormatException nfe) {
			throw new FLInvalidInputException(data + "is invalid number");
		}
		return parsedNum;
	}

	/**
	 * 
	 * @param data
	 * @param allFields
	 * @return
	 * @throws FLInvalidInputException
	 */
	private String parseString(String data, StringBuffer allFields)
			throws FLInvalidInputException {
		String validString = parseString(data);
		allFields.append(parseString(data));
		return validString;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @throws FLInvalidInputException
	 */
	private String parseString(String data) throws FLInvalidInputException {
		String validString;
		if (StringUtils.isEmpty(data)) {
			throw new FLInvalidInputException(data + "Invalid string");
		} else {
			String temp = data.trim();
			if ("".equals(temp)) {
				throw new FLInvalidInputException("Empty string");
			} else {
				validString = temp;
			}
		}
		return validString;
	}
}
