package com.empauthority.model;

import java.util.List;

public class EmpAuthorityService {
	
	private EmpAuthorityDAO_interface dao;
	
	
	public EmpAuthorityService() {
	    // 改用 JDBCDAO (如果不打算配置 JNDI)
	    dao = new EmpAuthorityJDBCDAO(); 
	}
	
	public void addEmpAuthority(Integer empId, Integer functionId) {
		EmpAuthorityVO vo = new EmpAuthorityVO();
		vo.setEmpId(empId);
		vo.setFunctionId(functionId);
		dao.insert(vo);
	}
	public void deleteEmpAuthority(Integer empId, Integer functionId) {
		dao.delete(empId, functionId);
	}
	public EmpAuthorityVO getOneEmpAuthority(Integer empId, Integer functionId) {
		return dao.findByPrimaryKey(empId, functionId);
	}
	public List<EmpAuthorityVO> getAll(){
		return dao.getAll();
	}

}
