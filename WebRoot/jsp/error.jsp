<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	ul{gravity="center"}
	li{text-align="left"}
	</style>

  </head>
  
  <body>
    <h2 align="center">操作错误</h2>
    <p>
       <b>发生错误的原因可能有：</b> 
    <ul>
    <li>
    用户名或密码为空，<a href="http://desktop-6m41rij:8080/Attendance%20Management%20System/">重试</a>
    </li>
    <li>
    用户不存在，请<a href="http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/signup.jsp" style="text-decoration:none">注册</a>
    </li>
    </ul>
    </p>
   
  </body>
</html>
