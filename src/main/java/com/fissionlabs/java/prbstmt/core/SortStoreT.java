/**
 * 
 */
package com.fissionlabs.java.prbstmt.core;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.fissionlabs.java.prbstmt.bean.Employee;
import com.fissionlabs.java.prbstmt.exception.FLProcessException;
import com.fissionlabs.java.prbstmt.util.EmpComparator1;
import com.fissionlabs.java.prbstmt.util.EmpComparator2;
import com.fissionlabs.java.prbstmt.util.EmpComparator3;

/**
 * Sort the employee list and initiate storing in file
 * 
 * @author Manjusha Mukkanti
 * 
 */
public class SortStoreT implements Runnable {
	public final static Logger LOGGER = LogManager.getLogger(SortStoreT.class);

	private List<Employee> empList;
	private FLFileWriter fWriter = new FLFileWriter();

	@Value("${s1FilePath}")
	private String s1FilePath;

	@Value("${s2FilePath}")
	private String s2FilePath;

	@Value("${s3FilePath}")
	private String s3FilePath;

	/**
	 * @return the empList
	 */
	public List<Employee> getEmpList() {
		return empList;
	}

	/**
	 * @param empList
	 *            the empList to set
	 */
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	/**
	 * Sort​ ​ and​ ​ store​ in​ ​ three​ ​ different​ ​ files​ ​ according​ ​
	 * to​ ​ following​ ​ conditions <li>Organization,​ ​ Experience,​ ​
	 * FirstName,​ ​ LastName</li> <li>Experience/age​ ​ ratio,​ ​ Organization</li>
	 * <li>Append​ ​ all​ ​ the​ ​ fields​ ​ of​ ​ each​ ​ record.</li>
	 */
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();

		if (empList.size() == 0) {
			LOGGER.info("Thread {} doesnt have data to sort and store",
					currentThreadName);
		} else {
			sortAndStoreData(
					s1FilePath.replace(".txt", currentThreadName + ".txt"),
					new EmpComparator1());
			sortAndStoreData(
					s2FilePath.replace(".txt", currentThreadName + ".txt"),
					new EmpComparator2());
			sortAndStoreData(
					s3FilePath.replace(".txt", currentThreadName + ".txt"),
					new EmpComparator3());
		}

	}

	/**
	 * 
	 * @param filePath
	 * @param empComparator
	 * @throws FLProcessException
	 */
	private void sortAndStoreData(String filePath,
			Comparator<Employee> empComparator) {

		String currentThreadName = Thread.currentThread().getName();
		LOGGER.debug("Thread {} processing sort and store data in {} ",
				currentThreadName, filePath);
		List<Employee> sortedEmpList = new Vector<Employee>();
		sortedEmpList.addAll(empList);
		Collections.sort(sortedEmpList, empComparator);
		try {
			Thread.sleep(5000);
			fWriter.write(sortedEmpList, filePath);
		} catch (FLProcessException exe) {
			LOGGER.error(
					"Thread {} failed to write in file {} with sorted data \n {}",
					currentThreadName, filePath, sortedEmpList, exe);
		} catch (InterruptedException exe) {
			LOGGER.error(
					"Thread {} interrupted while writing to file {} with sorted data \n {}",
					currentThreadName, filePath, sortedEmpList, exe);
		}
		LOGGER.debug("Thread {} processed sort and store data in {} ",
				currentThreadName, filePath);
	}
}
