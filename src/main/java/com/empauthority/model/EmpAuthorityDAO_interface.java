package com.empauthority.model;

import java.util.*;

public interface EmpAuthorityDAO_interface {
	//新增一筆權限
	public void insert(EmpAuthorityVO empAuthorityVO);
	// 更新一筆權限（通常用不到，因為 PK 是複合鍵）
	public void update(EmpAuthorityVO empAuthorityVO);
	// 刪除一筆權限（依 PK）
	public void delete(Integer empid, Integer functionid);
	// 查詢單筆（依 PK）
	public EmpAuthorityVO findByPrimaryKey(Integer empid, Integer functionid);
	// 查詢全部
	public List<EmpAuthorityVO> getAll();
	// 查詢某管理員的所有功能（1對多）
	public Set<EmpAuthorityVO> getFunctionByEmpId(Integer empid);
	// 查詢某功能的所有管理員（1對多）
	public Set<EmpAuthorityVO> getEmpsByFunctionId(Integer functionid);
}
