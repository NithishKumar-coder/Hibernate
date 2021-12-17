package com.service;

import java.util.List;

import com.exception.ApplicationException;
import com.model.Department;
import com.model.Employee;

public interface EmployeeService {
	public abstract int saveDepartment(Department department) throws ApplicationException;
	public abstract List<Employee> readDepartment() throws ApplicationException;
	public abstract int updateEmployee(Employee employee) throws ApplicationException;
	public abstract int deleteEmployee(int deleteId) throws ApplicationException;
	
}
