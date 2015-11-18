<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
  
  <body>
    <h1> 华中科技大学考勤管理系统</h1>
    <h2>考勤记录表</h2>
    <form action="TableHandler" method="post">
    <p>请选择周次：
    <select name="week">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    </select>
    </p>
    <table align="center">
    <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>班级</th>
    <th>
    语文
    <select name="yuwen">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    
    <th>
    数学
    <select name="shuxue">
   <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    
    <th>
    英语
    <select name="yingyu">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    
    <th>
    物理
    <select name="wuli">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    
    <th>
    化学 
    <select name="huaxue">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    
    <th>
    生物
    <select name="shengwu">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    </select>
    </th>
    </tr>
    
    <tr>
    <td>1</td>
    <td><input type="hidden" name="student1"  value="zhangyi"/>张一</td>
    <td>一班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen1"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue1"></input></td> 
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu1"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli1"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue1"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu1"></input></td>
    </tr>
    
    <tr>
    <td>2</td>
    <td><input type="hidden" name="student2"  value="zhangyi"/>张二</td>
    <td>二班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen2"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue2"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu2"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli2"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue2"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu2"></input></td>
    </tr>
    
    <tr>
    <td>3</td>
    <td><input type="hidden" name="student3"  value=""/>张三</td>
    <td>三班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen3"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue3"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu3"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli3"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue3"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu3"></input></td>
    </tr>
    
    <tr>
    <td>4</td>
    <td><input type="hidden" name="studnet4"  value="张四"/>张四</td>
    <td>四班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen4"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue4"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu4"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli4"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue4"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu"></input></td>
    </tr>
    
    <tr>
    <td>5</td>
    <td><input type="hidden" name="student5"  value=""/>张五</td>
    <td>五班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen5"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue5"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu5"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli5"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue5"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu5"></input></td>
    </tr>
    
    <tr>
    <td>6</td>
    <td><input type="hidden" name="student6"  value=""/>张六</td>
    <td>六班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen6"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue6"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu6"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli6"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue6"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu6"></input></td>
    </tr>
    
    <tr>
    <td>7</td>
    <td><input type="hidden" name="student7"  value=""/>张七</td>
    <td>七班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen7"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue7"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu7"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli7"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue7"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu7"></input></td>
    </tr>
    
    <tr>
    <td>8</td>
    <td><input type="hidden" name="student8"  value=""/>张八</td>
    <td>八班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen8"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue8"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu8"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli8"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue8"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu8"></input></td>
    </tr>
    
    <tr>
    <td>9</td>
    <td><input type="hidden" name="student9"  value=""/>张九</td>
    <td>九班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen9"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue9"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu9"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli9"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue9"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu9"></input></td>
    </tr>
    
    <tr>
    <td>10</td>
    <td><input type="hidden" name="student10"  value=""/>张十</td>
    <td>十班</td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yuwen10"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shuxue10"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="yingyu10"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="wuli10"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="huaxue10"></input></td>
    <td><input type="text" pattern="[0-9]{1}" style="width:80px" name="shengwu10"></input></td>
    </tr>
    
    
    

    <tr><td colspan="9"><input type="submit" value="提交" /></td></tr>
    </table>
    </form>
  </body>
</html>
