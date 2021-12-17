package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Department {
	@Id
	@Column(name = "dept_id") 
	private int departmentId;
	@Column(name = "dept_name") 
	private String departmentName;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> employee;

	public Department() {
		super();
	}

	public Department(int departmentId, String departmentName, List<Employee> employee) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employee = employee;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}



}