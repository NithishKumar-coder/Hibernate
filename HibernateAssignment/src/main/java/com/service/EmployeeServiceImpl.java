package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.ApplicationException;
import com.model.Department;
import com.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public int saveDepartment(Department department) throws ApplicationException{
		int result = -1;
		if(department != null)
		{
			EmployeeDao employeeDao = new EmployeeDaoImpl();	
			result = employeeDao.saveDepartmentDao(department);
		}
		else {
			throw new ApplicationException("Invalid data");
		}
		return result;
	}

	@Override
	public List<Employee> readDepartment() throws ApplicationException{
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();	
		List<Employee> employeeList = employeeDao.readDepartmentDao();
		
		return employeeList;
	}

	@Override
	public int updateEmployee(Employee employee) throws ApplicationException{
		if(employee != null)
		{
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			employeeDao.updateEmployeeDao(employee);
		}
		else {
			throw new ApplicationException("Invalid data");
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int deleteId) throws ApplicationException{
		if(deleteId != 0)
		{
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			employeeDao.deleteEmployeeDao(deleteId);
		}
		else {
			throw new ApplicationException("Invalid data");
		}
		return 0;
	}

}
