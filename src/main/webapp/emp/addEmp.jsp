<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
   EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>
--<%= empVO == null %> <!-- line 100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>新增後台管理員資料 - addEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>新增後台管理員資料 - addEmp.jsp</h3></td><td>
		 <h4><a href="<%=request.getContextPath()%>/emp/select_page.jsp"><img src="<%=request.getContextPath()%>/emp/images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" name="form1">
<table>
	
	<tr>
		<td>後台管理員姓名:</td>
		<td><input type="TEXT" name="empName" value="<%= (empVO==null)? "吳永志" : empVO.getEmpName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>帳號:</td>
		<td><input type="TEXT" name="Account"   value="<%= (empVO==null)? "peter111" : empVO.getAccount()%>" size="45"/></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="password" name="Password"   value="<%= (empVO==null)? "123456" : empVO.getPassword()%>" size="45"/></td>
	</tr>
	<tr>
		<td>狀態:<font color=red><b>*</b></font></td>
		<td>
		<select size="1" name="status">
				<option value="0">0
				<option value="1" selected>1
		</select>
		</td>	
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>

</html>