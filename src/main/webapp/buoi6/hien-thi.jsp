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
Them moi sinh vien:
<form action="/sinh-vien/them" method="post">
    <label>id</label>
    <input type="text" name="id" value="${sinhVien.id}"> <br>
    <label>Ten</label>
    <input type="text" name="ten" value="${sinhVien.ten}"> <br>
    <label>Diem</label>
    <input type="text" name="diem" value="${sinhVien.diem}"> <br>
    <label>Gioi tinh</label>
    <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh == "true" ? "checked" :""}> Nam
    <input type="radio" name="gioiTinh" value="false" ${sinhVien.gioiTinh == "false" ? "checked" :""}> Nu
    <br>
    <button>Them moi</button>
</form>
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
            <td><a href="/sinh-vien/chi-tiet?id=${sv.id}">Chi tiet</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
