package com.dao;

import java.util.List;

import com.exception.ApplicationException;
import com.model.Department;
import com.model.Employee;

public interface EmployeeDao {
	public abstract int saveDepartmentDao(Department department) throws ApplicationException;

	public abstract List<Employee> readDepartmentDao() throws ApplicationException;

	public abstract int updateEmployeeDao(Employee employee) throws ApplicationException;

	public abstract int deleteEmployeeDao(int deleteId) throws ApplicationException;

}
