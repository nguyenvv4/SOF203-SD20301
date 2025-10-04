<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/4/25
  Time: 07:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/cap-nhat" method="post">
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
    <button>Cap nhat</button>
</form>
</body>
</html>
