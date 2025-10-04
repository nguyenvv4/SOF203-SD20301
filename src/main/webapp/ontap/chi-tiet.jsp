<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/4/25
  Time: 08:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <label>id</label>
    <input type="text" name="id" value="${user.id}"> <br>
    <label>Ten</label>
    <input type="text" name="ten" value="${user.ten}"> <br>
    <label>Tuoi</label>
    <input type="text" name="tuoi" value="${user.tuoi}"> <br>
    <label>Email</label>
    <input type="text" name="email" value="${user.email}"> <br>
    <label>Gioi tinh</label>
    <input type="radio" name="gioiTinh" value="true" ${user.gioiTinh == "true" ? "checked" :""}> Nam
    <input type="radio" name="gioiTinh" value="false" ${user.gioiTinh == "false" ? "checked" :""}> Nu
    <br>
    <button type="submit">Cap nhat</button>
</form>

</body>
</html>
