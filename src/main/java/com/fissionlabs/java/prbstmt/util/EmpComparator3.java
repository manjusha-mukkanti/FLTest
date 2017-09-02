/**
 * 
 */
package com.fissionlabs.java.prbstmt.util;

import java.util.Comparator;

import com.fissionlabs.java.prbstmt.bean.Employee;

/**
 * Sort order : Append​ ​ all​ ​ the​ ​ fields​ ​ of​ ​ each​ ​ record.
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class EmpComparator3 implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAllFields().compareTo(e2.getAllFields());
	}

}
