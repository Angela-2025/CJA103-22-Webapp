<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有員工權限</title>
</head>
<body>
<h2>員工權限清單</h2>

<!-- 顯示錯誤訊息 -->
<c:if test="${not empty errorMsgs}">
    <ul style="color:red">
        <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</c:if>

<!-- 顯示所有權限 -->
<table border="1">
    <tr>
        <th>員工編號</th>
        <th>功能編號</th>
        <th>操作</th>
    </tr>
    <c:forEach var="auth" items="${empAuthorityList}">
        <tr>
            <td>${auth.empId}</td>
            <td>${auth.functionId}</td>
            <td>
                <!-- 查單筆 -->
                <form action="EmpAuthorityServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="getOne"/>
                    <input type="hidden" name="empId" value="${auth.empId}"/>
                    <input type="hidden" name="functionId" value="${auth.functionId}"/>
                    <input type="submit" value="查詢"/>
                </form>
                <!-- 刪除 -->
                <form action="EmpAuthorityServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="empId" value="${auth.empId}"/>
                    <input type="hidden" name="functionId" value="${auth.functionId}"/>
                    <input type="submit" value="刪除"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- 新增連結 (透過 Servlet 進入) -->
<p><a href="EmpAuthorityServlet?action=insertForm">新增權限</a></p>

</body>
</html>
