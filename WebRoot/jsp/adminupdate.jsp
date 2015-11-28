<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>录入和查询</title>
  </head>
  <%@page import="da.*" %>
  <body>
  <center>
  <h1>华中科技大学考勤管理系统</h1>
  <form action="UpdateHandler" method="post">
  请选择周次<br>
<select name="week">
<%for(int i = 1; i <= 16; i ++) {%>
<option value ="<%=i%>"><%=i %></option>
<%} %>
</select>

<table border="1">

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

  
  
  
  
  
  
  
 