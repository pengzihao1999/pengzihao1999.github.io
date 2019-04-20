<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript">
 function change()
 {
	
	 var ele=document.getElementById("vCode");
	 ele.src = "<c:url value='/VerifyCodeServlet'/>?xxx=" + new Date().getTime();
     
 }
 
 
 </script>
  </head>
  
  <body>
  <h1> 注册</h1>
  <p style="color: red; font-weight: 900">${msg }</p>
  <form action="<c:url value='/RegistServlet'/>" method="post">
  用户名：<input type="text" name="username" value="${user.username}"/>${errors.username}<br/>
  密 码 ：<input type="password" name="password" value="${user.password}"/>${errors.password}<br/>
  验证码:<input type="text" name="verifycode" value="${user.verifycode}" size="3"/>
        <img id="vCode" src="<c:url value='/VerifyCodeServlet'/>" />
        <a href="javascript:change()">换一张</a>${errors.verifyCode}<br/>
        <input type="submit" value="注册"/>
 </form>
  </body>
</html>
