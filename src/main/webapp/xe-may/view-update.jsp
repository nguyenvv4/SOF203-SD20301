<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 10/14/25
  Time: 07:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Sua xe may:
<form action="/xe-may/sua" method="post">
    So khung: <input type="text" name="soKhung" value="${xeMay.soKhung}"> <br>
    So may: <input type="text" name="soMay" value="${xeMay.soMay}"> <br>
    Khoi luong: <input type="text" name="khoiLuong" value="${xeMay.khoiLuong}"> <br>
    Phan khoi: <input type="text" name="phanKhoi" value="${xeMay.phanKhoi}"> <br>
    Trang thai:
    Con hoat dong <input type="radio" name="trangThai" value="true" ${xeMay.trangThai == true ? "checked" : ""}>
    Khong hoat dong <input type="radio" name="trangThai" value="false" ${xeMay.trangThai == false ? "checked" : ""}>
    <br>
    <button>Submit</button>
</form>
</body>
</html>
