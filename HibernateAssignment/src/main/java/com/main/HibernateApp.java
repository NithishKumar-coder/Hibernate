package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.ApplicationException;
import com.model.Department;
import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

public class HibernateApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input;
		input = scanner.nextLine();


if (input=="create") {

	Department department = new Department();
	department.setDepartmentId(3);
	department.setDepartmentName("IT");

	Employee emp1 = new Employee(43, "nithish", 1800.00F);
	Employee emp2 = new Employee(45, "hari", 1300.00F);
	Employee emp3 = new Employee(47, "kumar", 1200.00F);

	emp1.setDepartment(department);
	emp2.setDepartment(department);
	emp3.setDepartment(department);

	List<Employee> empList = new ArrayList<Employee>();
	empList.add(emp1);
	empList.add(emp2);
	empList.add(emp3);

	department.setEmployee(empList);

	EmployeeService employeeService = new EmployeeServiceImpl();
	try {
		int result = employeeService.saveDepartment(department);
		if (result != 0) {
			System.out.println("Record saved");
		}
	} catch (ApplicationException e) {
		e.printStackTrace();
	}
} else if (input="read") {

	EmployeeService employeeService1 = new EmployeeServiceImpl();
	try {
		List<Employee> employeeList = employeeService1.readDepartment();
		System.out.println("Total employees are : " + employeeList.size());
		if (employeeList.size() > 0) {
			for (Employee employee : employeeList) {
				System.out.println("Employee id : " + employee.getEmployeeId());
				System.out.println("Employee name :" + employee.getEmployeeName());
				System.out.println("Employee salary : " + employee.getEmployeeSalary());
				System.out.println("Department id : " + employee.getDepartment().getDepartmentId());
				System.out.println("Department id : " + employee.getDepartment().getDepartmentName());
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
else if (input="update") {
	Department department3 = new Department();
	department3.setDepartmentId(3);
	Employee employee = new Employee(102, "Raman", 1400.00F);
	employee.setDepartment(department3);
	
	EmployeeService employeeService2 = new EmployeeServiceImpl();
	try {
		int result = employeeService2.updateEmployee(employee);
		if (result != 0) {
			System.out.println("Record updated");
		}
	} catch (ApplicationException e) {
		e.printStackTrace();
	}
}

else {
	int deleteId = scanner.nextInt();
	EmployeeService employeeService3 = new EmployeeServiceImpl();
	try {
		int result = employeeService3.deleteEmployee(deleteId);
		if (result != 0) {
			System.out.println("Record deleted");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}


	
	}

}
