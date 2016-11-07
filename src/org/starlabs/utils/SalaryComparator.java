package org.starlabs.utils;

import java.util.Comparator;

import org.starlabs.EmployeDatabaseManagement.Employee;

public class SalaryComparator implements Comparator<Employee>  {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return Double.compare(emp1.getSalary(), emp2.getSalary());
	}
}
