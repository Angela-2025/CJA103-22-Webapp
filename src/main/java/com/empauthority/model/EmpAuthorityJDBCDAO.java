package com.empauthority.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmpAuthorityJDBCDAO implements EmpAuthorityDAO_interface {

    // JDBC 連線設定
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/momento?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "123456";

    private static final String INSERT_STMT = "INSERT INTO emp_authority (EMP_ID, FUNCTION_ID) VALUES(?, ?)";
    private static final String DELETE_STMT = "DELETE FROM emp_authority WHERE EMP_ID = ? AND FUNCTION_ID = ?";
    private static final String GET_ONE_STMT = "SELECT EMP_ID, FUNCTION_ID FROM emp_authority WHERE EMP_ID=? AND FUNCTION_ID=?";
    private static final String GET_ALL_STMT = "SELECT EMP_ID, FUNCTION_ID FROM emp_authority";

    @Override
    public void insert(EmpAuthorityVO vo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_STMT);
            pstmt.setInt(1, vo.getEmpId());
            pstmt.setInt(2, vo.getFunctionId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            closeResource(con, pstmt, null);
        }
    }

    @Override
    public void delete(Integer empid, Integer functionid) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE_STMT);
            pstmt.setInt(1, empid);
            pstmt.setInt(2, functionid);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            closeResource(con, pstmt, null);
        }
    }

    @Override
    public EmpAuthorityVO findByPrimaryKey(Integer empid, Integer functionid) {
        EmpAuthorityVO vo = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, empid);
            pstmt.setInt(2, functionid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                vo = new EmpAuthorityVO();
                vo.setEmpId(rs.getInt("EMP_ID"));
                vo.setFunctionId(rs.getInt("FUNCTION_ID"));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            closeResource(con, pstmt, rs);
        }
        return vo;
    }

    @Override
    public List<EmpAuthorityVO> getAll() {
        List<EmpAuthorityVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                EmpAuthorityVO vo = new EmpAuthorityVO();
                vo.setEmpId(rs.getInt("EMP_ID"));
                vo.setFunctionId(rs.getInt("FUNCTION_ID"));
                list.add(vo);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            closeResource(con, pstmt, rs);
        }
        return list;
    }

    @Override
    public void update(EmpAuthorityVO empAuthorityVO) {
        // TODO: 依需求補上 update SQL
    }

    @Override
    public Set<EmpAuthorityVO> getFunctionByEmpId(Integer empid) {
        return null;
    }

    @Override
    public Set<EmpAuthorityVO> getEmpsByFunctionId(Integer functionid) {
        return null;
    }

    // 共用資源釋放方法
    private void closeResource(Connection con, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try { rs.close(); } catch (SQLException se) { se.printStackTrace(System.err); }
        }
        if (pstmt != null) {
            try { pstmt.close(); } catch (SQLException se) { se.printStackTrace(System.err); }
        }
        if (con != null) {
            try { con.close(); } catch (Exception e) { e.printStackTrace(System.err); }
        }
    }
}
