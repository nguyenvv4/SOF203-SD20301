<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/7/25
  Time: 07:58
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
            <td>so khung</td>
            <td>so may</td>
            <td>khoi luong</td>
            <td>phan khoi</td>
            <td>trang thai</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${listXm}" var="xm">
        <tr>
            <td>${xm.soKhung}</td>
            <td>${xm.soMay}</td>
            <td>${xm.khoiLuong}</td>
            <td>${xm.phanKhoi}</td>
            <td>${xm.trangThai}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
