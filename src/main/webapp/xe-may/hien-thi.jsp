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

Them xe may:
<form action="/xe-may/them" method="post">
    So khung: <input type="text" name="soKhung"> <br>
    So may: <input type="text" name="soMay"> <br>
    Khoi luong: <input type="text" name="khoiLuong"> <br>
    Phan khoi: <input type="text" name="phanKhoi"> <br>
    Trang thai:
    Con hoat dong <input type="radio" name="trangThai" value="true">
    Khong hoat dong <input type="radio" name="trangThai" value="false">
    <br>
    <button>Submit</button>
</form>

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
            <td>${xm.trangThai == true ? "Con hoat dong" : "Khong hoat dong"}</td>
            <td>
                <a href="/xe-may/view-update?soKhung=${xm.soKhung}">View update</a>
                <a href="/xe-may/xoa?soKhung=${xm.soKhung}">Xoa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
