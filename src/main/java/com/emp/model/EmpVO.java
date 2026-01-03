package com.emp.model;
import java.sql.Date;
import java.sql.Timestamp;

public class EmpVO implements java.io.Serializable{
	private Integer empId;
	private String empName;
	private String account;
	private String password;
	private Timestamp createdAt;
	private Integer status;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}	
	public void setPassword(String password) {
		this.password = password;
	}	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}