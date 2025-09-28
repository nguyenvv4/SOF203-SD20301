<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 9/27/2025
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Bang thong tin:
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Ten</th>
        <th>Diem</th>
        <th>Gioi tinh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach}" var="sv">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.ten}</td>
            <td>${sv.diem}</td>
            <td>${sv.gioiTinh}</td>
            <td><a href="/sinh-vien/xoa?id=${sv.id}">Xoa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
