/**
 * 
 */
package com.fissionlabs.java.prbstmt.util;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.fissionlabs.java.prbstmt.bean.Employee;

/**
 * Sort order : experience/age​ ​ ratio,​ ​ Organization
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class EmpComparator2 implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		CompareToBuilder compareToBuilder = new CompareToBuilder();
		compareToBuilder.append(e1.getExpInMnths() / e1.getAgeInYrs(),
				e2.getExpInMnths() / e2.getAgeInYrs());
		compareToBuilder.append(e1.getOrganization(), e2.getOrganization());
		return compareToBuilder.toComparison();
	}

}
