<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacher.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%@page import="da.*" %>
  <%@page import="pd.*" %>
  <jsp:useBean id="type" type="pd.TeacherType" scope="request" />
  <input id="type" type="hidden" value="<jsp:getProperty name="type" property="type"/>" name="type"/>
  <script type="text/javascript">
  	var er = document.getElementById("type").value;
  	
  </script>
  <%String type = %>
  <body>
  <h2>您所教课程的到课情况为：</h2>
  <% %>
    <%= %>
  </body>
</html>
