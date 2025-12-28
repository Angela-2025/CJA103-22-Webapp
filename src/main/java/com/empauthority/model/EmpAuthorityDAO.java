package com.empauthority.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.empauthority.model.EmpAuthorityVO;

public class EmpAuthorityDAO implements EmpAuthorityDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO EMP_AUTHORITY (EMP_ID, FUNCTION_ID) VALUES(?, ?)";
	private static final String DELETE_STMT = "DELETE FROM EMP_AUTHORITY WHERE EMP_ID=? AND FUNCTION_ID=?";
	private static final String GET_ONE_STMT = "SELECT EMP_ID, FUNCTION_ID FROM EMP_AUTHORITY WHERE EMP_ID=? AND FUNCTION_ID=?";
	private static final String GET_ALL_STMT = "SELECT EMP_ID, FUNCTION_ID FROM EMP_AUTHORITY";

	@Override
	public void insert(EmpAuthorityVO vo) {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {
			pstmt.setInt(1, vo.getEmpId());
			pstmt.setInt(2, vo.getFunctionId());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("DB error: " + se.getMessage(), se);
		}
	}

	@Override
	public void delete(Integer empid, Integer functionid) {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(DELETE_STMT)) {
			pstmt.setInt(1, empid);
			pstmt.setInt(2, functionid);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("DB error: " + se.getMessage());
		}
	}

	@Override
	public EmpAuthorityVO findByPrimaryKey(Integer empid, Integer functionid) {
		EmpAuthorityVO vo = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {
			pstmt.setInt(1, empid);
			pstmt.setInt(2, functionid);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					vo = new EmpAuthorityVO();
					vo.setEmpId(rs.getInt("EMP_ID"));
					vo.setFunctionId(rs.getInt("FUNCTION_ID"));
				}
			}
		} catch (SQLException se) {
			throw new RuntimeException("DB error: " + se.getMessage(), se);
		}
		return vo;
	}

	@Override
	public List<EmpAuthorityVO> getAll() {
		List<EmpAuthorityVO> list = new ArrayList<>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				EmpAuthorityVO vo = new EmpAuthorityVO();
				vo.setEmpId(rs.getInt("EMP_ID"));
				vo.setFunctionId(rs.getInt("FUNCTION_ID"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new RuntimeException("DB error: " + se.getMessage(), se);
		}
		return list;
	}

	@Override
	public void update(EmpAuthorityVO empAuthorityVO) {
		
	}

	@Override
	public Set<EmpAuthorityVO> getFunctionByEmpId(Integer empid) {
		return null;
	}

	@Override
	public Set<EmpAuthorityVO> getEmpsByFunctionId(Integer functionid) {
		return null;
	}
}