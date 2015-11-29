<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'counselor.jsp' starting page</title>
    
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
  <center>
  <p>
  请选择您想要查询的结果：：
  </p>
 <input type="button" name="Input" value="查询个人" onclick="window.location.href='http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/attendencerecord.jsp'"/>
<input type="button" name="Update" value="查询全班" onclick="window.location.href='http://desktop-6m41rij:8080/Attendance%20Management%20System/jsp/adminupdate.jsp'"/>

  </center>
  </body>
</html>
