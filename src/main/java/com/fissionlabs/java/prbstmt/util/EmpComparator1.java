/**
 * 
 */
package com.fissionlabs.java.prbstmt.util;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.fissionlabs.java.prbstmt.bean.Employee;

/**
 * Sort order : Organization,​ ​ Experience,​ ​ FirstName,​ ​ LastName 
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class EmpComparator1 implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		CompareToBuilder compareToBuilder = new CompareToBuilder();
		compareToBuilder.append(e1.getOrganization(), e2.getOrganization());
		compareToBuilder.append(e1.getExpInMnths(), e2.getExpInMnths());
		compareToBuilder.append(e1.getFirstName(), e2.getFirstName());
		compareToBuilder.append(e1.getLastName(), e2.getLastName());
		return compareToBuilder.toComparison();
	}

}
