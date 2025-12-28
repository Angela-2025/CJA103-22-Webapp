<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>員工權限明細</title>
</head>
<body>
<h2>員工權限明細</h2>

<!-- 顯示錯誤訊息 -->
<c:if test="${not empty errorMsgs}">
    <ul style="color:red">
        <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</c:if>

<!-- 顯示單筆資料 -->
<c:if test="${not empty empAuthorityVO}">
    <table border="1">
        <tr>
            <th>員工編號</th>
            <td>${empAuthorityVO.empId}</td>
        </tr>
        <tr>
            <th>功能編號</th>
            <td>${empAuthorityVO.functionId}</td>
        </tr>
    </table>
</c:if>

<!-- 返回清單 -->
<p><a href="<c:url value='empauthority.do?action=getAll'/>">回權限清單</a></p>
</body>
</html>
