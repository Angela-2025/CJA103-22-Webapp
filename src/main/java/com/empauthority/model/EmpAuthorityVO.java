package com.empauthority.model;

import java.io.Serializable;

public class EmpAuthorityVO implements Serializable {
	private Integer empid;
	private Integer functionid;

	public Integer getEmpId() {
		return empid;
	}

	public void setEmpId(Integer empId) {
		this.empid = empId;
	}

	public Integer getFunctionId() {
		return functionid;
	}

	public void setFunctionId(Integer functionId) {
		this.functionid = functionId;
	}
}