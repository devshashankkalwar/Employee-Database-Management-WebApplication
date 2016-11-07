package org.starlabs.utils;

import java.util.Comparator;

import org.starlabs.EmployeDatabaseManagement.Employee;

public class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
	}
