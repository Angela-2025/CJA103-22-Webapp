<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>EmpAuthority: Home</title>

<style>
  table#table-1 {
    width: 450px;
    background-color: #CCCCFF;
    margin-top: 5px;
    margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>EmpAuthority: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>這是員工權限管理的首頁</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
  <font style="color:red">請修正以下錯誤:</font>
  <ul>
    <c:forEach var="message" items="${errorMsgs}">
      <li style="color:red">${message}</li>
    </c:forEach>
  </ul>
</c:if>

<ul>
  <li><a href="<c:url value='empauthority.do?action=getAll'/>">List</a> all EmpAuthorities.<br><br></li>

  <%-- 
     註解掉：因為這是複合主鍵表，Servlet 需要同時接收 empId 與 functionId。
     單獨輸入 empId 會導致 Servlet 拋出例外。
  <li>
    <form method="post" action="empauthority.do">
      <b>後台管理員編號:</b>
      <input type="text" name="empId">
      <input type="hidden" name="action" value="getOne_For_Display">
      <input type="submit" value="送出">
    </form>
  </li>
  --%>

  <li>
    <form method="post" action="empauthority.do">
      <b>選擇權限查詢 (下拉選單):</b><br>
      
      員工編號: 
      <select size="1" name="empId">
         <c:forEach var="empAuthVO" items="${empAuthorityList}">
             <option value="${empAuthVO.empId}">${empAuthVO.empId}</option>
         </c:forEach>
      </select>
      
      功能編號: 
      <select size="1" name="functionId">
         <c:forEach var="empAuthVO" items="${empAuthorityList}">
             <option value="${empAuthVO.functionId}">${empAuthVO.functionId}</option>
         </c:forEach>
      </select>

      <input type="hidden" name="action" value="getOne_For_Display">
      <input type="submit" value="查詢">
    </form>
  </li>
</ul>

<h3>權限管理</h3>
<ul>
  <li><a href="<c:url value='addEmpAuthority.jsp'/>">Add</a> a new EmpAuthority.</li>
</ul>

</body>
</html>