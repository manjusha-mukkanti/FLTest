/**
 * 
 */
package com.fissionlabs.java.prbstmt.bean;

import org.springframework.stereotype.Component;

/**
 * Bean class to hold the input passed by user in the format as below FirstName​
 * ​ (String),​ ​ LastName(String), Experience(Months),​ ​ Age(Years),​ ​
 * Organization(String)
 * 
 * @author Manjusha Mukkanti
 * 
 */
@Component
public class Employee {

	private String input;
	private String firstName;
	private String lastName;
	private int expInMnths;
	private int ageInYrs;
	private String organization;
	private String allFields;

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the expInMnths
	 */
	public int getExpInMnths() {
		return expInMnths;
	}

	/**
	 * @param expInMnths
	 *            the expInMnths to set
	 */
	public void setExpInMnths(int expInMnths) {
		this.expInMnths = expInMnths;
	}

	/**
	 * @return the ageInYrs
	 */
	public int getAgeInYrs() {
		return ageInYrs;
	}

	/**
	 * @param ageInYrs
	 *            the ageInYrs to set
	 */
	public void setAgeInYrs(int ageInYrs) {
		this.ageInYrs = ageInYrs;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the allFields
	 */
	public String getAllFields() {
		return allFields;
	}

	/**
	 * @param allFields
	 *            the allFields to set
	 */
	public void setAllFields(String allFields) {
		this.allFields = allFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", expInMnths=" + expInMnths + ", ageInYrs=" + ageInYrs
				+ ", organization=" + organization + "]";
	}

}
