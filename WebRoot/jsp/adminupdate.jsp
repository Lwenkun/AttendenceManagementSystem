<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
  
  <body>
  <center>
    <h1>华中科技大学考勤管理系统</h1>
    <form action="UpdateHandler" method="post">
    
    <p>请选择学号：<select name="week">
    <%for(int i = 1; i <= 16; i ++) {%>
     <option value ="<%=i%>"><%=i %></option>
     <%} %>
    </select></p>
 
 <table border="1" align="center">

<tr>
<th>学号：</th>
<td><input type="text" name="studentID" /></td>
</tr>

<%ArrayList<String> projects = GlobalInfo.getProjectList(); %>
<%for(int i = 0; i < projects.size(); i++) { %>
<tr>
<th><%=projects.get(i) %></th>
<td><input type="text" name="<%=projects.get(i)%>"/></td>
</tr> 
<%} %>

<tr>
<td colspan="2" align="center"><input type ="submit" value="保存修改" /></td>
</tr>

</table>

</form>
</center>
  </body>
</html>
