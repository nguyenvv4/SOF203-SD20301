<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/16/25
  Time: 07:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/them" method="post">

    <label >hoTen</label>
    <input type="text" name="hoTen"> <br>
    <label >diaChi</label>
    <input type="text" name="diaChi"> <br>
    <label >gioiTinh</label>
    <input type="radio" name="gioiTinh" value="Nam"> Nam
    <input type="radio" name="gioiTinh" value="Nữ"> Nữ
    <br>
    <label >trangThai</label>
    <input type="radio" name="trangThai" value="true"> hoat dong
    <input type="radio" name="trangThai" value="false">  khong hoat dong <br>
    <button type="submit">Them</button>
</form>

<table>
    <thead>
    <tr>
        <td>id</td>
        <td>ho ten</td>
        <td>dia chi</td>
        <td>gioi tinh</td>
        <td>trang thai</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="sv">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.hoTen}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.gioiTinh}</td>
            <td>${sv.trangThai == true ? 'hoat dong' : 'khong hoat dong'}</td>
            <td><a href="/sinh-vien/xoa?id=${sv.id}">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
