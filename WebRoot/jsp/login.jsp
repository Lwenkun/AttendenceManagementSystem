<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Attendence Management System</title>
</head>

<body>
<h1 align="center"> 华中科技大学考勤管理系统 </h1>
<form action="Login" method="post" >
<table border="0" align="center">
<tr>
<td>请登录</td>
<td>还没有帐号？<a href="http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/signup.jsp" style="text-decoration:none" >点此注册</a></td>
</tr>
<tr>
<td>用户名:</td>
<td><input type="text" name="userName"/></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" name="password"/></td>
</tr>
<tr><td colspan="2" align="center"><input type="submit" name="Submit" value="确定" width="40" height="20" /></td></tr>
</table>
</form>
</body>
</html>