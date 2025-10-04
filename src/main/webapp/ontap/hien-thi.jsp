<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/4/25
  Time: 08:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Ho ten</td>
        <td>Email</td>
        <td>Tuoi</td>
        <td>gioiTinh</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.ten}</td>
            <td>${user.email}</td>
            <td>${user.tuoi}</td>
            <td>${user.gioiTinh}</td>
            <td><a href="/user/chi-tiet?id=${user.id}">Chi tiet</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
