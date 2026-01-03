package com.emp.model;

import java.util.List;

public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		dao = new EmpJDBCDAO();
	}

	public EmpVO addEmp(String empName, String account, String password, java.sql.Timestamp createdAt, Integer status) {

		EmpVO empVO = new EmpVO();

		empVO.setEmpName(empName);
		empVO.setAccount(account);
		empVO.setPassword(password);
		empVO.setCreatedAt(createdAt);
		empVO.setStatus(status);
		dao.insert(empVO);
		
		return empVO;
	}

	public EmpVO updateEmp(Integer empId, String empName, String password, Integer status) {

		EmpVO empVO = new EmpVO();

		empVO.setEmpId(empId);
		empVO.setEmpName(empName);
		empVO.setPassword(password);
		empVO.setStatus(status);
		
		dao.update(empVO);

		return empVO;
	}

	public void deleteEmp(Integer empno) {
		dao.delete(empno);
	}

	public EmpVO getOneEmp(Integer empId) {
		return dao.findByPrimaryKey(empId);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
}
