<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signup.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1 align="center">华中科技大学考勤管理系统</h1>
<form action="SignUp" method="post" >
<table border="0" align="center">

<tr>
<td colspan="2" align="center"><b>请注册</b> <a href="http://desktop-6m41rij:8080/Attendance%20Management%20System/" style="text-decoration:none">登陆</a></td>
</tr>

<tr>
<td>用户名:</td>
<td><input type="text" name="userName"/></td>
</tr>

<tr>
<td>密码：</td>
<td><input type="password" name="password"/></td>
</tr>

<tr>
<td>您的身份:</td>
<td>
<select name="identity">
<option value="teacher" >老师</option>
<option value="counselor" >辅导员</option>
<option value="administrator" >管理员</option>
</select>
</td>
</tr>

<tr>
<td>您教授的科目：</td>
<td style="font-size:15px">
<select name="type">
<option value="Assembly" >汇编</option>
<option value="Oop" >面向对象</option>
<option value="Data_Structure" >数据结构</option>
<option value="Circuit_Theory" >电路理论</option>
<option value="Physics">大学物理</option>
<option value="Complex_Function" >复变函数</option>
</select>
（若您不是老师，可以不填此项）
</td>
</tr>

<tr><td colspan="2" align="center"><input type="submit" name="Submit" value="确定" width="40" height="20" /></td></tr>
</table>
</form>
  </body>
</html>
