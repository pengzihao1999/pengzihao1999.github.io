<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>好友列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="demo.css">
	

  </head>
  
  <body>
  
<h3 align="center">好友列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>好友账号</th>
		<th>好友昵称</th>
	
		<th>群聊名称</th>
	</tr>
	<c:forEach items="${sessionScope.userlist}"  var ="user">
	<tr>
		<td>${user.ID}</td>
		<td>${user.username}</td>
		
		<td>${user.groupname}</td>

		<td>
		
			
			<a href="<c:url value='/ChatServlet?${requestScope.myid},${user.ID}'/>">点击这里和我聊天</a>
		</td>
		
	</tr>
	
	</c:forEach>
	
	
</table>
	<div id = "element">
	<div><button><a href="<c:url value='/GroupServlet?${requestScope.myid}'/>">点击这里进入群聊室</a></button></div>

 	</div>
  </body>
</html>
