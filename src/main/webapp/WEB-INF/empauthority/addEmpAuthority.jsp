<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增員工權限</title>
</head>
<body>
<h2>新增員工權限</h2>

<!-- 顯示錯誤訊息 -->
<c:if test="${not empty errorMsgs}">
    <ul style="color:red">
        <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</c:if>

<form action="<c:url value='EmpAuthorityServlet'/>" method="post">
    <input type="hidden" name="action" value="insert"/>
    <table>
        <tr>
            <td>員工編號：</td>
            <td><input type="text" name="empId"/></td>
        </tr>
        <tr>
            <td>功能編號：</td>
            <td><input type="text" name="functionId"/></td>
        </tr>
    </table>
    <input type="submit" value="新增"/>
</form>

<p><a href="<c:url value='EmpAuthorityServlet?action=getAll'/>">回權限清單</a></p>
</body>
</html>
