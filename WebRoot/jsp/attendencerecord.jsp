<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'attendencerecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	table,td,th{
	border:1px solid;
	border-collapse:collapse;
	text-align:center;
	}
	td{
	padding:3px;
	}
	h1,h2{
	text-align:center;
	}
	p{
	text-align:center;
	}
	</style>

  </head>
  <%@ page import="da.*" %>
  <body>
    <h1> 华中科技大学考勤管理系统</h1>
    <h2>考勤记录表</h2>
    <form action="TableHandler" method="post">
    <p>请选择周次：
    <select name="week">
    <%for(int i = 1; i <=16; i ++) {%>
    <option value="<%=i%>"><%=i%></option>
    <%} %>
    </select>
    </p>

    <table align="center">
    <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>班级</th>
    
    <%!ArrayList<String> projects = GlobalInfo.getProjectList(); %>
    <%for(int i = 0; i < projects.size(); i ++) { %>
    <%String project = projects.get(i); %>
    <th>
   <%=project %>
    <select name="<%=project %>">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    <%} %>
    </tr>
    
    <%! ArrayList<GlobalInfo.StudentInfo> infoList = GlobalInfo.getStudentInfoList(); %>
    <%for(int i = 0; i < infoList.size(); i ++) { %>
    <%GlobalInfo.StudentInfo info = infoList.get(i); %>
    <tr>
    <td><%=info.getStudentID() %></td>
    <td><%=info.getName() %></td>
    <td><%=info.getClassName() %></td>
    <%for(int j = 0; j < projects.size(); j++) {%>
    <%String project = projects.get(j); %>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="<%=project + j%>"></input></td>
    <%} %>
    </tr>
    <%} %>
    
    <tr><td colspan="9"><input type="submit" value="提交" /></td></tr>
    </table>
    </form>
  </body>
</html>
